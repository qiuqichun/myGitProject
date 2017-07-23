package cn.boc.sh.sfjh.transport.ftp.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.esbuilder.base.ServiceException;
import org.esbuilder.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.boc.sh.sfjh.transport.ftp.FtpClientService;

@Component
public class FtpClientServiceImpl implements FtpClientService {

	private static ThreadLocal<FTPClient> ftpClient = new ThreadLocal<FTPClient>();
	
	private static Logger LOG = LoggerFactory.getLogger(FtpClientServiceImpl.class);

	@Value("${transport.ftp.host:21.196.82.11}")
	private String host;  //FTP主机名  21.196.82.11 ceshi:22.196.68.131

	@Value("${transport.ftp.port:21}")
	private int port;  //FTP端口 21 ceshi:21
	
	@Value("${transport.ftp.username:ftpuser}")
	private String username;  //FTP用户名 ftpuser ceshi:kxy

	@Value("${transport.ftp.password:ftpuser}")
	private String password; //FTP密码 ftpuser ceshi:kxy

	@Value("${transport.ftp.remoteWorkDirectory:/dcds/data/qztget}")
	private String remoteWorkDirectory; //远程工作目录  /dcds/data/qzt ceshi:/spark
	
	@Value("${transport.ftp.localWorkDirectory:/opt/spark_data_download}")
	private String localWorkDirectory;	//FTP本地根目录   d:/app/

	public FtpClientServiceImpl() throws IOException {
		super();
	}

	/**
	 * ftp连接
	 * 
	 * @throws SocketException
	 * @throws IOException
	 */
	private FTPClient connect(String remoteWorkDir) throws IOException {

		FTPClient client = new FTPClient();
		client.setDefaultPort(this.port);
		try {

			LOG.debug("begin connect to the ftp server...");

			// 连接服务器
			client.connect(this.host);
			int reply = client.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				throw new IOException("the ftp server refuse connect...");
			}

			LOG.debug("connect to the ftp server success...");

			// 登录服务器
			LOG.debug("begin login to the ftp server...");

			if (!client.login(username, password)) {

				throw new IOException("login to the ftp server error...");
			}

			// 转到对应根目录
			if (remoteWorkDir != null) {

				client.changeWorkingDirectory(remoteWorkDir);

			}

			// 设置文件上传模式

			// client.setFileTransferMode(mode);

			ftpClient.set(client);

			LOG.debug("login to the ftp server success...");

			return client;

		} catch (IOException e) {
			LOG.debug("connect to the ftp server error...", e);
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException f) {
					// do nothing
				}
			}

			throw e;

		}

	}

	private void disconnect() {

		FTPClient client = ftpClient.get();
		if (client != null) {

			try {

				if (client.isConnected()) {

					client.disconnect();
				}

			} catch (Exception e) {

			}

			ftpClient.remove();

		}

	}

	public File downloadDirectory(String filePath) throws ServiceException {

		return this.downloadDirectory(this.remoteWorkDirectory, filePath);

	}

	public File downloadDirectory(String remoteHome, String filePath) throws ServiceException {
		return this.downloadDirectory(remoteHome, this.localWorkDirectory, filePath);
	}

	public File downloadDirectory(String remoteHome, String localHome,
			String filePath) throws ServiceException {

		File localDir = new File(localHome);
		if (!localDir.exists()) {
			localDir.mkdirs();
		}

		return this.downloadDirectory(remoteHome, localDir, filePath);
	}

	public File downloadDirectory(String remoteHome, File localHome,
			String filePath) throws ServiceException {

		if (filePath == null) {
			throw new ServiceException("必须提供下载目录名称");
		}

		if (!localHome.exists()) {
			localHome.mkdirs();
		}

		File localDir = new File(localHome, filePath);
		if (!localDir.exists()) {
			localDir.mkdirs();
		}

		try {
			
			this.connect(remoteHome);

			if (!StringUtils.isNullOrEmpty(filePath)) {
				ftpClient.get().changeWorkingDirectory(filePath);
			}

			FTPFile[] files = ftpClient.get().listFiles();
			for (FTPFile ftpFile : files) {
				
				if (ftpFile.isDirectory()) {
					if (ftpFile.getName().equals(".")
							|| ftpFile.getName().equals("..")) {
						continue;
					}
					this.downloadDirectoryInner(ftpFile, localDir);
					
				} else {
					this.downloadFileInner(ftpFile, localDir);
				}
			}
			return localDir;
			
		} catch (IOException e) {
			LOG.error("文件["+ localHome.getName() +"]下载失败..." + e);
			throw new ServiceException("文件["+ localHome.getName() +"]下载失败...");
		}finally{
			this.disconnect();
		}
	}

	private void downloadDirectoryInner(FTPFile ftpFile, File localDir) throws ServiceException {

		try {
			// 进入对应目录
			ftpClient.get().changeWorkingDirectory(ftpFile.getName());

			// 创建本地目录
			File localInnerDir = new File(localDir, ftpFile.getName());
			if (!localInnerDir.exists()) {
				localInnerDir.mkdirs();
			}

			FTPFile[] files = ftpClient.get().listFiles();
			for (FTPFile ftpInnerFile : files) {

				if (ftpInnerFile.isDirectory()) {

					if (ftpFile.getName().equals(".")
							|| ftpFile.getName().equals("..")) {
						continue;
					}

					this.downloadDirectoryInner(ftpInnerFile, localInnerDir);

				} else {

					this.downloadFileInner(ftpFile, localDir);
				}

			}
			// 返回上级目录
			ftpClient.get().changeToParentDirectory();
			
		} catch (IOException e) {
			LOG.error("文件["+ ftpFile.getName() +"]下载失败..." + e);
			throw new ServiceException("文件["+ ftpFile.getName() +"]下载失败...");
		}
	}

	private void downloadFileInner(FTPFile ftpFile, File localDir) throws ServiceException {

		LOG.info("[{}] 下载开始...", new Object[] { ftpFile.getName() });

		File localFile = new File(localDir, ftpFile.getName());

		try {
			OutputStream output = new BufferedOutputStream(new FileOutputStream(
					localFile));

			ftpClient.get().retrieveFile(ftpFile.getName(), output);

			output.flush();

			output.close();

			LOG.info("[{}] 下载成功...", new Object[] { ftpFile.getName() });
		} catch (Exception e) {
			LOG.error("文件["+ ftpFile.getName() +"]下载失败..." + e);
			throw new ServiceException("文件["+ ftpFile.getName() +"]下载失败...");
		}
	}

	public File downloadFile(String fileName) throws ServiceException {
		boolean exist = existFile(fileName);
		if(!exist){
			LOG.info("[{}] 不存在...", new Object[] { fileName});
			throw new ServiceException("文件["+ fileName +"]不存在...");
		}
		
		return this.downloadFile(this.remoteWorkDirectory, fileName);
	}

	public File downloadFile(String remoteHome, String fileName) throws ServiceException {

		return this.downloadFile(remoteHome, this.localWorkDirectory, fileName);

	}

	public File downloadFile(String remoteHome, String localHome, String fileName) throws ServiceException{

		if (fileName == null) {
			throw new ServiceException("必须提供下载文件名称...");
		}
		try {

			this.connect(remoteHome);

			File localDir = new File(localHome);
			if (!localDir.exists()) {
				localDir.mkdirs();
			}

			File localFile = new File(localDir, fileName);

			FileOutputStream output = new FileOutputStream(localFile);

			ftpClient.get().setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.get().retrieveFile(fileName, output);

			output.close();
			
			return localFile;
			
		} catch (Exception e) {
			LOG.error("文件["+ fileName +"]下载失败..." + e);
			throw new ServiceException("文件["+ fileName +"]下载失败...");
		}finally{
			this.disconnect();
		}
	}

	/**
	 * 上传文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void uploadFile(String fileName) throws ServiceException {

		File dir = new File(this.localWorkDirectory);

		File fileToUpload = new File(dir, fileName);

		if (!fileToUpload.exists()) {
			LOG.info("FTP本地根目录：{}",localWorkDirectory);
			LOG.warn("文件["+ fileName +"] 不存在...");
			return;
		}

		try {
			LOG.info("开始上传文件["+ fileName +"] ...");
			this.connect(this.remoteWorkDirectory);

			this.uploadFileInner(fileToUpload);

			LOG.info("文件["+ fileName +"]上传成功 ...");

		} catch (IOException e) {
			LOG.error("文件目录" + this.remoteWorkDirectory +"]或其子目录连接失败..." + e);
			throw new ServiceException("文件目录[" + this.remoteWorkDirectory +"]或其子目录连接失败...");
		} finally {
			this.disconnect();
		}
	}
	@Override
	public void uploadFile(String baseDirectory, String remoteDirectory) throws ServiceException {

		File dirToUpload = new File(new File(this.localWorkDirectory), baseDirectory);
		
		if (!dirToUpload.exists()) {
			LOG.warn("本地文件目录[" + baseDirectory + "] 不存在...");
			return;
		}

		try {
			LOG.info("[{}] 上传开始...", new Object[] { baseDirectory });
			this.connect(this.remoteWorkDirectory);
			
			String fileNames[] = remoteDirectory.split("/");
			if(fileNames != null && fileNames.length > 0){
				for (String tempName : fileNames) {
					if (!StringUtils.isNullOrEmpty(tempName)) {
						ftpClient.get().makeDirectory(tempName);
						ftpClient.get().changeWorkingDirectory(tempName);
					}
				}
			}
			ftpClient.get().changeWorkingDirectory(remoteDirectory);
		
			this.uploadFileInner(dirToUpload);

		} catch (IOException e) {
			LOG.error("文件目录" + this.remoteWorkDirectory +"]或其子目录连接失败..." + e);
			throw new ServiceException("文件目录[" + this.remoteWorkDirectory +"]或其子目录连接失败...");
		} finally {
			this.disconnect();
		}

	}
	
	private void uploadFileInner(File file) throws ServiceException{

		FTPClient client = ftpClient.get();

		if (file.exists()) {

			try {
				if (file.isDirectory()) {
					// 在服务器建立对应目录
					client.makeDirectory(file.getName());
					// 进入服务器对应目录
					client.changeWorkingDirectory(file.getName());

					// 进行对应目录下的文件上传
					File[] files = file.listFiles();

					// 循环进行文件上传
					if (files != null && files.length > 0) {
						for (File tmpFile : files) {
							uploadFileInner(tmpFile);
						}
					}

					// 返回上层目录
					client.changeToParentDirectory();

				} else {

					InputStream input;

					input = new FileInputStream(file);

					if (getExtension(file.getName()).equals("xml")) {
						client.setFileType(FTP.ASCII_FILE_TYPE);
					} else {
						client.setFileType(FTP.BINARY_FILE_TYPE);
					}
					
					LOG.info("Begin upload the file [" + file.getPath()+"]...");
					client.storeFile(file.getName(), input);

					input.close();
					LOG.info("End upload the file [" + file.getPath()+"]...");
				}
			} catch (FileNotFoundException e) {
				LOG.error("文件【" + file.getName() +"】不存在..." + e);
				throw new ServiceException("文件不存在...");
			} catch (IOException e) {
				LOG.error("文件【" + file.getName() +"】提交失败..." + e);
				throw new ServiceException("文件提交失败...");
			}

		} else {
			LOG.info("Not exist file of [" + file.getAbsolutePath() + "]...");
		}

	}

	/**
	 * 删除申请文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void deleteFile(String fileName) throws FileNotFoundException,
			IOException {

		try {
			
			LOG.info("删除[{}]文件开始...", new Object[] { fileName });

			this.connect(this.remoteWorkDirectory);

			this.deleteFileInner(fileName);
			
			LOG.info("删除[{}]文件结束...", new Object[] { fileName });

		} catch (IOException e) {

			LOG.error("删除[{}]文件失败...", new Object[] { fileName });
			LOG.error("删除[{}]文件失败的错误信息为[{}]：", fileName,e);
			throw e;

		} finally {

			this.disconnect();
		}
	}

	private void deleteFileInner(String fileName) throws FileNotFoundException,
			IOException {

		FTPClient client = ftpClient.get();

		// 是否是目录
		if (client.changeWorkingDirectory(fileName)) {
			// 进行对应目录下的文件删除
			FTPFile files[] = client.listFiles();
			// 循环删除文件
			if (files != null && files.length > 0) {
				for (FTPFile tmpFile : files) {
					deleteFileInner(tmpFile.getName());
				}
			}
			// 暂存当前目录名，并回退上层目录
			String tempDir = fileName;
			client.changeToParentDirectory();
			// 删除当前目录
			client.removeDirectory(tempDir);
		} else {
			LOG.debug("begin delete the file [{}]", fileName);
			boolean isOk = client.deleteFile(fileName);
			if (!isOk) {
				LOG.debug("delete the ftpfile [{}] error", fileName);
			}
			LOG.debug("delete the file [{}]", fileName);
		}

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemoteWorkDirectory() {
		return remoteWorkDirectory;
	}

	public void setRemoteWorkDirectory(String remoteWorkDirectory) {
		this.remoteWorkDirectory = remoteWorkDirectory;
	}

	public String getLocalWorkDirectory() {
		return localWorkDirectory;
	}

	public void setLocalWorkDirectory(String localWorkDirectory) {
		this.localWorkDirectory = localWorkDirectory;
	}

	public String getExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return "jpg";
	}

	public boolean existFile(String fileName) throws ServiceException {

		return existFile(null, fileName);
	}

	@Override
	public boolean existFile(String filePath, String fileName) throws ServiceException {
		try {

			if (fileName == null) {

				throw new ServiceException("必须提供文件名称");
			}

			this.connect(this.remoteWorkDirectory);

			if (!StringUtils.isNullOrEmpty(filePath)) {
				ftpClient.get().changeWorkingDirectory(filePath);
			}

			String fileNames[] = ftpClient.get().listNames();

			for (String tempName : fileNames) {

				if (tempName.equalsIgnoreCase(fileName)) {

					return true;
				}

			}

			return false;

		} catch (Exception e) {
			throw new ServiceException("判断文件是否存在失败", e);

		} finally {

			this.disconnect();
		}
	}
	public static void main(String[] args) throws ServiceException, IOException {
		System.out.println("action");
		new FtpClientServiceImpl().uploadFile("/activity_20161013");
		
	}

}
