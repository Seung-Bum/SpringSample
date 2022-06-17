package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.nudle.Nudle;
import co.kr.mono.studydb.model.nudle.NudleOrder;
import co.kr.mono.studydb.model.nudle.OrderProduct;
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
class NudleChainServiceTest {

    @Autowired
    NudleChainService nudleChainService;

    ObjectMapper mapper ; // Json으로 변경

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("국수 판매현황 + 알파")
    public void nudleOrderList() throws JsonProcessingException {
        NudleOrder nudleOrderList = nudleChainService.searchNudleOrder(1);
        log.info("Json 변환 : {} ",mapper.writeValueAsString(nudleOrderList));
    }

    @Test
    @DisplayName("상세 현황 + 알파")
    public void nudleOrderList1() throws JsonProcessingException {
        List<OrderProduct> orderProductList = nudleChainService.searchOrderProduct(1);
        log.info("Json 변환 : {} ",mapper.writeValueAsString(orderProductList));
    }

    @Test
    @DisplayName("제품 + 알파")
    public void nudleOrderList2() throws JsonProcessingException {
        Nudle nudle = nudleChainService.searchNudle();
        log.info("Json 변환 : {} ",mapper.writeValueAsString(nudle));
    }


}