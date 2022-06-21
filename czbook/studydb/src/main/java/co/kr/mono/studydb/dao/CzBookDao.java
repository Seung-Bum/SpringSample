package co.kr.mono.studydb.dao;


import co.kr.mono.studydb.model.book.CzBookLoanHist;
import co.kr.mono.studydb.model.book.CzMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CzBookDao {

    // member_id로 member 조회하기
    public CzMember selectCzMemberByPrimaryKey(String member_id);

    // 회원 대출정보 조회
    public CzMember selectCzMemberByPrimaryKey1(String member_id);

    // 회원 대출정보 + 도서정보
    public CzMember selectCzMemberByPrimaryKey2();
    
    // 대출 히스토리 + 모든정보
    public List<CzBookLoanHist> selectCzBookLoanHistByPrimaryKey(String loan_id);
}
