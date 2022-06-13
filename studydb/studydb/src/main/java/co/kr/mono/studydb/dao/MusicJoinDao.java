package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicJoinDao {

    public List<Album> selectArtistByPrimaryKey1(String mst_id);

    public Artist selectArtistByPrimarykey2(String mst_id);

    public Album selectAlbumByPrimaryKey1(String album_id);

    public Album selectAlbumByPrimaryKey2(String album_id);
}
