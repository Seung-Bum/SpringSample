package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.AreaSalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AreaSalesDao {
    public AreaSalesDTO findAreaSales(String areacd);
    public Map  findAreaSalesMap(String areacd);
    public Map  findMsaleByMultiParm(Map condMap);
    public List findMsaleByMultiReturn(Map condMap);
}
