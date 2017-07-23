package myServices;

import mappers.AlbumList;

public class AlbumListServices implements MapperInterface{
	AlbumList albumListMapper;

	public AlbumList getAlbumListMapper() {
		return albumListMapper;
	}

	public void setAlbumListMapper(AlbumList albumListMapper) {
		this.albumListMapper = albumListMapper;
	}

	@Override
	public int selectCount() {
		int selectCount = albumListMapper.selectCount();
		
		
		
		return selectCount;
	}
	
}
