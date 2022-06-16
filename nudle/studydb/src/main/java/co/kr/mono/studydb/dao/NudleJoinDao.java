package co.kr.mono.studydb.dao;

import co.kr.mono.studydb.model.nudle.NudleOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NudleJoinDao {

    // 주문현황 + 알파
    public NudleOrder selectOrderByOrderId(int order_id) ;

}
