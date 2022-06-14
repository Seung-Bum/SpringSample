package co.kr.mono.studydb.model.music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    private String mstId  ;
    private String mstName  ;
    private String debutDate  ;

    // 체인방식 : 아티스트 입장에서 내용을 가져올때
    // 앨범 : 콜랙션맵핑
    // 노래 : 콜랙션맵핑, 앨범의 내용을 통해가져오기 때문에 앨범에 노래의 정보가 있어야함
//    private List<Album> album;
//    private List<Song> songs;


    @Override
    public String toString() {
        return "Artist{" +
                "mstId='" + mstId + '\'' +
                ", mstName='" + mstName + '\'' +
                ", debutDate='" + debutDate + '\'' +
                '}';
    }
}
