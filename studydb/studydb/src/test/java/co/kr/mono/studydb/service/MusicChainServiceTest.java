package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
import co.kr.mono.studydb.model.music.Song;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class MusicChainServiceTest {

    @Autowired
    MusicChainService musicChainService ;

    ObjectMapper mapper ; // Json으로 변경

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Album에 담긴 노래목록 조회")
    public void albumList() throws JsonProcessingException {
        List<Song> songList = musicChainService.searchSongList("BS1");// ,"Rain");
/*
        log.info("Song 매핑   : {}", songList); // 기준

        songList.forEach(song -> {
            log.info("song 매핑   : {}", song);
            //logger.info("  |- Album 매핑   : {}", song.getAlbum());
        });
*/
        log.info("Json 변환 : {} ",mapper.writeValueAsString(songList));

    }

    @Test
    @DisplayName("Artist ID(pk) 으로 Artist 상세 정보조회")
    public void searchArtist() throws JsonProcessingException {

        Artist artist = musicChainService.searchArtist("BTS");
        //log.info("Artist 매핑 : {}", artist);

        log.info("Json 변환 : {} ",mapper.writeValueAsString(artist));

    }

    @Test
    @DisplayName("엘범ID(pk)로 Album 상세 정보조회")
    public void serachAlbum() throws JsonProcessingException {
        Album album = musicChainService.searchAlubm("BS1");

        /*log.info("Artist 매핑   : {}", album.getArtist()); // 1 : Assocation Mapping

        log.info("album 매핑   : {}", album); // 기준
        for (Song song : album.getSongs()) { // m : Collection Mapping
            log.info("  |- song 매핑   : {}", song);
        }*/
        log.info("Json 변환 : {} ",mapper.writeValueAsString(album));
    }
}
