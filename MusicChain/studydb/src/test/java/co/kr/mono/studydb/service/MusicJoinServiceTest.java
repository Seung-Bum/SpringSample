package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.music.Album;
import co.kr.mono.studydb.model.music.Artist;
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
class MusicJoinServiceTest {

    @Autowired
    MusicJoinService musicJoinService;

    ObjectMapper mapper ;

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }
/*
    @Test
    @DisplayName("Album에 담긴 노래목록 조회")
    public void albumList() throws JsonProcessingException {
        List<Album> albumList = musicJoinService.searchArtistList("BTS");

      //  System.out.println(albumList);

        albumList.forEach(album -> {
            log.info("Artist 매핑   : {}", album.getArtist());
            log.info("  |- Album 매핑   : {}", album);
        });

        log.info("Json 변환 : {} ",mapper.writeValueAsString(albumList));
    }

    @Test
    @DisplayName("Album에 담긴 노래목록 조회")
    public void searchArtist() throws JsonProcessingException {
        Artist artist = musicJoinService.searchArtist("BTS");
        System.out.println(artist);

        log.info("Artist 매핑   : {} {}", artist.getMstId(), artist.getMstName());

        List<Album> albums = artist.getAlbum();

        albums.forEach(album -> log.info("  |- Album 매핑   : {},{}",
                album.getAlbumTitle(), album.getOpenDate()));

        log.info("Json 변환 : {} ",mapper.writeValueAsString(artist));
    }

    @Test
    @DisplayName("Album정보 조회")
    public void searchAlubm() throws JsonProcessingException {
        Album album = musicJoinService.searchAlubm("BS1");
        log.info("album 매핑   : {}", album);

        album.getSongs().forEach(song -> log.info("  |- song 매핑   : {}", song));

        log.info("Json 변환 : {} ",mapper.writeValueAsString(album));
    }
*/
    @Test
    @DisplayName("Album과 Artist정보 조회")
    public void searchAlubmandArtist() throws JsonProcessingException {
        Album album = musicJoinService.searchAlubmwithArtist("BS1");

        log.info("album 매핑   : {}", album);


     //   log.info("<Musition 매핑>   : {}", album.getArtist().getMstName());
        log.info("<album 매핑>  앨범id : {} ,앨범순서 : {},  앨범타이틀 : {}, 발매일자 : {}",
                album.getAlbumId(),
                album.getAlbumSeq(), album.getAlbumTitle(), album.getOpenDate());

        album.getSongs().forEach(song ->
                log.info("  |- <song 매핑>  노래제목: {} => 노래길이 : {}",
                        song.getSongName(), song.getPlayTime()));

        System.out.println("-------------------");
        album.getSongs().stream()
                .filter(song -> song.getPlayTime() > 9.0f)
                .forEach(System.out::println);
        System.out.println("-------------------");

        log.info("Json 변환 : {} ",mapper.writeValueAsString(album));

    }
}
