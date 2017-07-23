package actions;

import myServices.AlbumListServices;

public class AlbumAction {
	/**
	 * 将模型中的变量放进action中来连接mybatis
	 */
	AlbumListServices 	albumListServices ;
	public AlbumListServices getAlbumListServices() {
		return albumListServices;
	}
	public void setAlbumListServices(AlbumListServices albumListServices) {
		this.albumListServices = albumListServices;
	}

	/**
	 * 测试spring+mybatis+struts
	 * @auth qqc
	 * @data 2016年4月25日 下午11:24:33
	 * @return
	 */
	
	public String selectTest(){
		int selectCount = albumListServices.selectCount();
		System.out.println(selectCount);
		return "success";
		
	}
}
