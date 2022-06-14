package co.kr.mono.studydb.model.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
public class CzBookLoanHist {

    private String loanId ;
    private String loanSeq ;
    private String startYMD ;
    private String endYMD ;
    private String status ;

    private CzBookLoan czBookLoan;

    private CzBook czBook;

    private CzMember czMember;

    @Override
    public String toString() {
        return "CzBookLoanHist{" +
                "loanId='" + loanId + '\'' +
                ", loanSeq='" + loanSeq + '\'' +
                ", startYMD='" + startYMD + '\'' +
                ", endYMD='" + endYMD + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
