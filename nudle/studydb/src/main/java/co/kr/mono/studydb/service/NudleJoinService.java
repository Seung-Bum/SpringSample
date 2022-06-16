package co.kr.mono.studydb.service;

import co.kr.mono.studydb.dao.NudleJoinDao;
import co.kr.mono.studydb.model.nudle.NudleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NudleJoinService {

    @Autowired
    NudleJoinDao nudleJoinDao;

    public NudleOrder searchNudleOrderList(int order_id) {
        NudleOrder nudleOrderList = nudleJoinDao.selectOrderByOrderId(order_id);
        System.out.println(nudleOrderList);
        return nudleOrderList;
    }


}
