package co.kr.mono.studydb.service;

import co.kr.mono.studydb.model.AreaSalesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 1. 컨트롤러의 역할을 대신함 (요청을 전담처리)
// Controller는 넘어온 매개변수를 이용해 Service 객체를 호출

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class SalesServiceTest {

    @Autowired
    SalesService salesService;
    ObjectMapper mapper;

    @BeforeEach
    void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("특정지역에서 판매한 제품 정보 1건 DTO로 매핑, input : String, output : DTO ")
    public void selectTestOneStaticParam() throws JsonProcessingException {

        AreaSalesDTO sale = salesService.selectSales("30"); // 서비스 호출
        log.info("Json 변환 : {} ", mapper.writeValueAsString(sale)); // mapper(DAO) 호출
    }

    @Test
    @DisplayName("input:String output:map")
    public void selectTestOneStaticParamMap()throws JsonProcessingException{

        Map<String, Object> sale = salesService.selectSalesMap("30"); // 서비스 호출
        // Map을 이용할 경우 모든 파라미터를 알고있지 않아도 쉽게 받아올 수 있다.

        sale.forEach((key,val) ->{
            log.info("* {} : {} ",key, val);
        });
        log.info("Json 변환 : {}" ,mapper.writeValueAsString(sale)); // mapper(DAO) 호출
    }

    @Test
    @DisplayName("input : String , output :map")
    public void selectTestfindMsaleByMultiReturn() throws JsonProcessingException {

        Map<String, Object> param = new HashMap<>();
        param.put("prodId", "0");
        param.put("prodNm", "note");

        List<Map<String, Object>> sale = salesService.findMsaleByMultiReturn(param); // 서비스 호출

        sale.forEach(
                row -> {
                    row.forEach((key, val) -> {
                        log.info("* {} : {}", key, val);
                        log.info("--------");
                    }  );
                    log.info("==========");
                }
        );


        //log.info("Json 변환 : {} ",mapper.writeValueAsString(sale));
        //log.info("Json Preety 변환 : {} ",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale));
    }


}