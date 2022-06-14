package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicJoinDao {

    // 아티스트 테이블과 앨범 테이블 조인 => 앨범ID로 검색, 앨범 정보와 아티스트 정보
    public List<Album> selectArtistByPrimaryKey1(String mst_id);

    public Artist selectArtistByPrimaryKey2(String mst_id);

    public Album selectAlbumByPrimaryKey1(String album_id);

    public Album selectAlbumByPrimaryKey2(String album_id);

}
