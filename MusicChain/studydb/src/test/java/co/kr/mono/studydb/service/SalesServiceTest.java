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

//@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class SalesServiceTest {

    @Autowired
    SalesService salesService;
    ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("특정지역에서 판매한 제품 정보 1건_DTO로 매핑, input : String, output : DTO ")
    public void selectTestOneStaticParam() throws JsonProcessingException {

        AreaSalesDTO sale = salesService.selectSales("30");
        log.info("Json 변환 : {} ", mapper.writeValueAsString(sale));
        //log.info("Json Preety 변환 : {} ",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale));
    }

    @Test
    @DisplayName("input : String , output :map")
    public void selectTestOneStaticParamMap() throws JsonProcessingException {

        Map<String, Object> sale = salesService.selectSalesMap("30");
        sale.forEach((key, val) -> {
            log.info("* {} : {}", key, val);
        });

        log.info("Json 변환 : {} ", mapper.writeValueAsString(sale));
        //log.info("Json Preety 변환 : {} ",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale));
    }

    @Test
    @DisplayName("input : map , output :map")
    public void selectTestMutlParam() throws JsonProcessingException {

        /* 데이터 먼저 확인 */
        Map<String, Object> param = new HashMap<>();
        param.put("prodId", "00004");
        param.put("prodNm", "세탁기");

        Map<String, Object> sale = salesService.selectMultiParamsMap(param);
        sale.forEach((key, val) -> {
            log.info("* {} : {}", key, val);
        });

        log.info("Json 변환 : {} ", mapper.writeValueAsString(sale));
        //log.info("Json Preety 변환 : {} ",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale));
    }

    @Test
    @DisplayName("input : String , output :map")
    public void selectTestfindMsaleByMultiReturn() throws JsonProcessingException {

        Map<String, Object> param = new HashMap<>();
        param.put("prodId", "0");
        param.put("prodNm", "note");

        List<Map<String, Object>> sale = salesService.findMsaleByMultiReturn(param);

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