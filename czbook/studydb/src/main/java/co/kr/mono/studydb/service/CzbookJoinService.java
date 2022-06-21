package co.kr.mono.studydb.service;

// * 컨트롤러 -> 서비스
// 서비스는 POJP 객체로 구성
// DAO는 단일 데이터 접근 로직이다.
// 말 그대로 SQL 하나 보내고 결과를 받는 것이 전부인 로직.
// 하나의 비즈니스 로직이 단순이 SQL 하나 보내서 끝나는가? 전혀 아니다.
// 여러 번의 DB 접근이 필요하고, 어떤 서비스는 병렬식으로 동시접근하여 데이터를 가져와야 하는 상황도 발생한다.
// 그렇기 떄문에 Service라는 개념이 나온 것이다. 하나의 서비스를 위해 여러개의 DAO를 묶은 트랜잭션이 생성되고,
// Service는 곧 트랜잭션의 단위가 된다.
// 또 다른 점으로, Controller 내부에서 필요한 여러 Service를 구분하는 필요성을 가진다.
// 비슷한 요청이더라도 내부 로직이 달라야한다면 Controller는 매우 복잡해질 가능성이 있다.
// 이러한 점을 분리하여 Controller는 단순이 요청을 받아 해당 요청에 맞는 Service에 데이터를 주입하는 역할.
// Service는 자신이 수행해야 할 서비스를 진행할 뿐이었다.

import co.kr.mono.studydb.dao.CzBookDao;
import co.kr.mono.studydb.model.book.CzBookLoanHist;
import co.kr.mono.studydb.model.book.CzMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CzbookJoinService {

    @Autowired
    CzBookDao czBookDao;

    // 회원기준 : member_id로 member 조회
    public CzMember searchMember(String member_id ){
        CzMember member = czBookDao.selectCzMemberByPrimaryKey(member_id);
        return member ;
    }

    // 회원기준 : 도서 대출 회원검색
    public CzMember searchMemberWithBookLoan(String member_id){
        CzMember member = czBookDao.selectCzMemberByPrimaryKey1(member_id);
        return member ;
    }

    // 회원기준 : 도서정보 + 대출정보 + 회원
    public CzMember searchMemberWithBookLoanAndBook(){
        CzMember member = czBookDao.selectCzMemberByPrimaryKey2();
        return member ;
    }

    // 대출 히스토리 + 모든정보
    public List<CzBookLoanHist> searchLoanHist(String loan_id){
        List<CzBookLoanHist> loanHist = czBookDao.selectCzBookLoanHistByPrimaryKey(loan_id);
        return loanHist ;
    }

}
