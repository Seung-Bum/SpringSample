package co.kr.mono.studydb.model.book;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
@ToString
public class CzBookLoan {

    private String loanId ;
    private String memberId ;
    private String bookId ;
    private String status ;

    private CzBook czBook;

}
