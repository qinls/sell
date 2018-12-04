package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Transient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
//        ProductCategory producCategory = repository.getOne(1);

        Optional<ProductCategory> producCategory = repository.findById(1);
        log.info(producCategory.toString());
    }

    @Test
//    @Transient   // 测试数据回滚
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("1最爱", 10);

//        ProductCategory productCategory = repository.getOne(1);
//        productCategory.setCategoryType(5);
        ProductCategory res = repository.save(productCategory);
        Assert.assertNotNull(res);
    }

    @Test
    public void findProductCategoriesByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3);
        List<ProductCategory> result = repository.findProductCategoriesByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}