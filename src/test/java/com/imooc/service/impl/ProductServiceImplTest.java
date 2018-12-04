package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductsStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/5.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Test
    public void findAll2() throws Exception {
        log.info("看看你 {}", productService.findAll2(1, 3));
    }

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        Optional<ProductInfo> productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.get().getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfos = productService.findUpAll();
        Assert.assertNotEquals(0, productInfos.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());

    }

    @Test
    public void save() throws Exception {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("小米粥");
        productInfo.setProductPrict(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很不错");
        productInfo.setProductIcon("http://cccc.jpg");
        productInfo.setProductStatus(ProductsStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}