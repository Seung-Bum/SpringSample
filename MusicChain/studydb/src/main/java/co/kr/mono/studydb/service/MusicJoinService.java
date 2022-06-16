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

    public List<Album> searchArtistList(String mst_id ){
        List<Album> albums = musicJoinDao.selectArtistByPrimaryKey1(mst_id);
        return albums ;
    }

    public Artist searchArtist(String mst_id ){
        Artist artist = musicJoinDao.selectArtistByPrimaryKey2(mst_id);
        return artist ;
    }

    public Album searchAlubm(String album_id){
        Album album = musicJoinDao.selectAlbumByPrimaryKey1(album_id);
        return album;
    }

    public Album searchAlubmwithArtist(String album_id){
        Album album = musicJoinDao.selectAlbumByPrimaryKey2(album_id);
        return album;
    }
}
