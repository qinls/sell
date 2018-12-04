package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setProductName("皮蛋粥2");
        productInfo.setProductPrict(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很不错");
        productInfo.setProductIcon("http://cccc.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findProductInfosByProductStatus() throws Exception {
        List<ProductInfo> productInfos = repository.findProductInfosByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findProductInfoByProductStatus() throws Exception {
        List<ProductInfo> productInfo = repository.findProductInfoByProductStatus(0);
        Assert.assertNotEquals(0,productInfo.size());
    }

}