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
    //private Album album;

    @Override
    public String toString() {

        return "Song [albumId=" + albumId + ",songName=" + songName + ", playTime=" + playTime
                + "]";

    }
}
