package co.kr.mono.studydb.service;

import co.kr.mono.studydb.dao.MusicChainDao;
import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import co.kr.mono.studydb.model.music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicChainService {

    @Autowired
    MusicChainDao musicChainDao;

    public List<Song> searchSongList(String album_id) {
        List<Song> songs = musicChainDao.selectSongByAlbumKey(album_id);
        System.out.println(songs);
        return songs;
    }

    public Artist searchArtist(String mst_id) {
        Artist artist = musicChainDao.selectArtistByPrimaryKey(mst_id);
        System.out.println(artist);
        return artist;
    }

    public Album searchAlubm(String album_id) {
        Album album = musicChainDao.selectAlbumByPrimaryKey(album_id);
        System.out.println(album);
        return album;
    }
}
