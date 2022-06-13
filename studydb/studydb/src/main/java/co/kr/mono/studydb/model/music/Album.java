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
//    private  Artist artist;
    private  List<Song> songs ;  // album_id

    @Override
    public String toString() {
		/*
		return "Album [albumId=" + albumId + ", artist=" + artist + ", albumSeq=" + albumSeq + ", albumTitle="
				+ albumTitle + ", openDate=" + openDate + ", songs=" + songs + "]";

		return "Album [albumId=" + albumId + ", albumSeq=" + albumSeq + ", albumTitle="
				+ albumTitle + ", openDate=" + openDate + ", songs=" + songs + "]";
		*/
        return "Album [albumId=" + albumId + ", albumSeq=" + albumSeq + ", albumTitle="
                + albumTitle + ", openDate=" + openDate + "]";
    }


}
