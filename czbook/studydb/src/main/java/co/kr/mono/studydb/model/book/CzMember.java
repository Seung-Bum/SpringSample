package co.kr.mono.studydb.model.book;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
@ToString
public class CzMember {

    private String memberId ;
    private String name ;
    private String addr ;

    private List<CzBookLoan> czBookLoan;

}
