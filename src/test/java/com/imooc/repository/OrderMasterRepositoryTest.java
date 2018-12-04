package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1235");
        orderMaster.setBuyerName("小师兄");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("地址在北京");
        orderMaster.setBuyerOpenid("110");
        orderMaster.setOrderAmount(new BigDecimal(3.64));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOrderMasterByBuyerOpenid() throws Exception {
        PageRequest request = PageRequest.of(1,3);
        Page<OrderMaster> result = repository.findOrderMasterByBuyerOpenid("110", request);
        System.out.println(result.getTotalElements());
    }


}