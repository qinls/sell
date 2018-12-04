package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/5.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void finOne() throws Exception {
        ProductCategory productCategory = categoryService.finOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findProductCategoriesByCategoryTypeIn() throws Exception {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> list = categoryService.findProductCategoriesByCategoryTypeIn(numList);
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("我是火腿肠", 6);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}