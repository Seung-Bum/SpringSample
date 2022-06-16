package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.nudle.NudleOrder;
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
class NudleJoinServiceTest {

    @Autowired
    NudleJoinService nudleJoinService;

    ObjectMapper mapper ; // Json으로 변경

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("국수 판매현황")
    public void nudleOrderList() throws JsonProcessingException {
        NudleOrder nudleOrderList = nudleJoinService.searchNudleOrderList(1);
        log.info("Json 변환 : {} ",mapper.writeValueAsString(nudleOrderList));
    }

}