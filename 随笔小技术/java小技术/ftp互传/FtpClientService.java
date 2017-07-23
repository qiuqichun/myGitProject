/**
 * 
 */
package cn.boc.sh.sfjh.transport.ftp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.esbuilder.base.ServiceException;
import org.springframework.stereotype.Component;

/**
 * @author josh
 * 
 */
@Component
public interface FtpClientService {

	/**
	 * 上传指定文件
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ServiceException 
	 */
	public void uploadFile(String fileName) throws ServiceException;
	/**
	 * 上传指定文件至给定远程目录
	 * 
	 * @param fileName
	 * @param remoteDirectory
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ServiceException 
	 */
	public void uploadFile(String fileName, String remoteDirectory) throws ServiceException;
	/**
	 * 删除指定文件
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void deleteFile(String fileName) throws FileNotFoundException,
			IOException;
	
	/**
	 * 
	 * 下载目录
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public File downloadDirectory(String filePath) throws Exception;

	/**
	 * 
	 * 下载文件
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public File downloadFile(String fileName) throws Exception;
	
	
	/**
	 * 
	 * 下载指定远程目录下的文件
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public File downloadFile(String remoteHome,String fileName) throws Exception;
	
	/**
	 * 
	 *判断对应文件是否存在
	 *
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public boolean existFile(String fileName) throws Exception;
	
	
	/**
	 * 
	 * 判断指定目录下对应文件是否存在
	 *
	 * @param filePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public boolean existFile(String filePath,String fileName) throws Exception;

}
