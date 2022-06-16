package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.nudle.Nudle;
import co.kr.mono.studydb.model.nudle.NudleOrder;
import co.kr.mono.studydb.model.nudle.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NudleChainDao {

    // 주문현황 + 알파
    public NudleOrder selectOrderByPrimaryKey(int order_id) ;

    // 상세 + 알파
    public List<OrderProduct> selectOrderByPrimaryKey1() ;

    // 제품 + 알파
    public Nudle selectOrderByPrimaryKey2() ;


}