package co.kr.mono.studydb.service;

import co.kr.mono.studydb.dao.NudleChainDao;
import co.kr.mono.studydb.model.nudle.Nudle;
import co.kr.mono.studydb.model.nudle.NudleOrder;
import co.kr.mono.studydb.model.nudle.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NudleChainService {

    @Autowired
    NudleChainDao nudleChainDao;

    public NudleOrder searchNudleOrder(int order_id) {
        NudleOrder nudleOrderList = nudleChainDao.selectOrderByPrimaryKey(order_id);
        System.out.println(nudleOrderList);
        return nudleOrderList;
    }

    public List<OrderProduct> searchOrderProduct() {
        List<OrderProduct> OrderProductList = nudleChainDao.selectOrderByPrimaryKey1();
        System.out.println(OrderProductList);
        return OrderProductList;
    }

    public Nudle searchNudle() {
        Nudle nudle = nudleChainDao.selectOrderByPrimaryKey2();
        System.out.println(nudle);
        return nudle;
    }

}
