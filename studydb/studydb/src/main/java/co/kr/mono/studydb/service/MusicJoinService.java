package co.kr.mono.studydb.service;

import co.kr.mono.studydb.dao.MusicJoinDao;
import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicJoinService {

    @Autowired
    MusicJoinDao musicJoinDao;


    // 아티스트 테이블과 앨범 테이블 조인 => 앨범ID로 검색, 앨범 정보와 아티스트 정보
    // 리턴 타입이 Album 이기 때문에 앨범 model에 Artist 객체가 있어야 한다.
    public List<Album> searchArtistList(String mst_id ){
        List<Album> albums = musicJoinDao.selectArtistByPrimaryKey1(mst_id);
        return albums ;
    }

    public Artist searchArtist(String mst_id ){
        Artist artist = musicJoinDao.selectArtistByPrimaryKey2(mst_id);
        return artist ;
    }

    public Album searchAlubm(String album_id ){
        Album album = musicJoinDao.selectAlbumByPrimaryKey1(album_id);
        return album;
    }

    public Album searchAlubmwithArtist(String album_id ){
        Album album = musicJoinDao.selectAlbumByPrimaryKey2(album_id);
        return album;
    }
}
