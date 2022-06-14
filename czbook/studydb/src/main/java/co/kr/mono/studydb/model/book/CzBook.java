package co.kr.mono.studydb.model.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
public class CzBook {

    private String bookId ;
    private String bookName ;
    private String writer ;
    private String publisher ;
    private String publisherYMD ;

    @Override
    public String toString() {
        return "CzBook{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", Writer='" + writer + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", PublisherYMD='" + publisherYMD + '\'' +
                '}';
    }
}
