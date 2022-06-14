package co.kr.mono.studydb.model.music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
public class Album {

    private  String albumId   ;
    private  int    albumSeq   ;
    private  String albumTitle    ;
    private  String openDate  ;


    // 노래 중심으로 앨범과 뮤지션 정보 가져오기
    private  Artist artist;


    // 앨범을 통해 노래의 정보들을 가져올때 해당 필드가 필요함
    private  List<Song> songs ;  // album_id


    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumSeq=" + albumSeq +
                ", albumTitle='" + albumTitle + '\'' +
                ", openDate='" + openDate + '\'' +
                ", artist=" + artist +
                ", songs=" + songs +
                '}';
    }
}
