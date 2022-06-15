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

    public List<NudleOrder> searchNudleOrder(int order_id) {
        List<NudleOrder> nudleOrderList = nudleChainDao.selectOrderByPrimaryKey(order_id);
        System.out.println(nudleOrderList);
        return nudleOrderList;
    }

    public List<OrderProduct> searchOrderProduct(int order_id) {
        List<OrderProduct> OrderProductList = nudleChainDao.selectOrderByPrimaryKey1(order_id);
        System.out.println(OrderProductList);
        return OrderProductList;
    }


    public List<Nudle> searchNudle(int product_id) {
        List<Nudle> nudle = nudleChainDao.selectOrderByPrimaryKey2(product_id);
        System.out.println(nudle);
        return nudle;
    }

}
