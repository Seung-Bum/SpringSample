package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.AreaSalesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


// 마이바티스(Mybais)는 Mapper 인터페이스를 제공합니다.
// 우리는 DAO대신 매퍼를 사용할 것입니다.
// 매퍼를 사용하면 일일이 DAO를 만들지 않고 인터페이스만을 이용해서 좀더 편하게 개발할 수 있습니다.
// 마이비티스는 자바코드와 SQL문을 분리하여 편리하게 관리하도록 합니다.
// SQL문은 *.xml 형식으로 저장합니다.
// DAO를 Repository라고도 한다.
@Mapper
public interface AreaSalesDao { // 2. 컨트롤러 -> 서비스 -> DAO(Mapper) -> DB
    public AreaSalesDTO findAreaSales(String areacd);
    public Map findAreaSalesMap(String areacd);

    public Map findMsaleByMultiParm(Map condMap);
    public List findMsaleByMultiReturn(Map condMap);
}
