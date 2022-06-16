package co.kr.mono.studydb.service;

import co.kr.mono.studydb.dao.AreaSalesDao;
import co.kr.mono.studydb.model.AreaSalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesService {

    @Autowired
    AreaSalesDao areaSalesDao;

    public AreaSalesDTO selectSales(String areaCd) {
        AreaSalesDTO areaSales = areaSalesDao.findAreaSales(areaCd);
        //System.out.println(areaSales);
        return areaSales;
    }

    public Map<String, Object> selectSalesMap(String areaCd) {
        Map<String, Object> areaSales = areaSalesDao.findAreaSalesMap(areaCd);
        //System.out.println(areaSales);
        return areaSales;
    }

    public Map<String, Object> selectMultiParamsMap(Map<String, Object> condMap) {
        Map<String, Object> areaSales = areaSalesDao.findMsaleByMultiParm(condMap);
        //System.out.println(areaSales);
        return areaSales;
    }

    public List<Map<String, Object>> findMsaleByMultiReturn(Map<String, Object> condMap) {
        List<Map<String, Object>>  areaSales = areaSalesDao.findMsaleByMultiReturn(condMap);
        //System.out.println(areaSales);
        return areaSales;
    }



}
