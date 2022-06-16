package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import co.kr.mono.studydb.model.music.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicChainDao {
    public List<Song> selectSongByAlbumKey(String album_id) ;
    public Artist selectArtistByPrimaryKey(String mst_id);
    public Album selectAlbumByPrimaryKey(String album_id);
}
