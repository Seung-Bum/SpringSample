package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.book.CzBookLoanHist;
import co.kr.mono.studydb.model.book.CzMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CzbookJoinServiceTest {

    @Autowired
    CzbookJoinService czbookJoinService;

    ObjectMapper mapper ;

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }


    @Test
    @DisplayName("Member 조회")
    public void searchMember() throws JsonProcessingException {
        CzMember member = czbookJoinService.searchMember("101");
        log.info("Json 변환 : {} ",mapper.writeValueAsString(member));
    }

    @Test
    @DisplayName("Member + 대출정보")
    public void searchMemberWithBookLoan() throws JsonProcessingException {
        CzMember member = czbookJoinService.searchMemberWithBookLoan("101");
        log.info("Json 변환 : {} ",mapper.writeValueAsString(member));
    }

    @Test
    @DisplayName("Member + 대출정보 + 도서정보")
    public void searchMemberWithBookLoanAndBook() throws JsonProcessingException {
        CzMember member = czbookJoinService.searchMemberWithBookLoanAndBook("101");
        log.info("Json 변환 : {} ",mapper.writeValueAsString(member));
    }

    @Test
    @DisplayName("도서대출 히스토리")
    public void searchLoanHist() throws JsonProcessingException {
        List<CzBookLoanHist> czBookLoanHist = czbookJoinService.searchLoanHist("L1022");
        log.info("Json 변환 : {} ",mapper.writeValueAsString(czBookLoanHist));
    }
}