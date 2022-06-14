package co.kr.mono.studydb.model.music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private String albumId;
    private String songName ;
    private Float playTime ;


    // 노래 중심으로 앨범과 뮤지션 정보 가져오기
    private Album album;
    private Artist artist;


    @Override
    public String toString() {
        return "Song{" +
                "albumId='" + albumId + '\'' +
                ", songName='" + songName + '\'' +
                ", playTime=" + playTime +
                ", artist=" + artist +
                ", album=" + album +
                '}';
    }
}
