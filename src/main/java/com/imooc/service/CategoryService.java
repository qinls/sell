package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Administrator on 2018/11/5.
 */
public interface CategoryService {
    ProductCategory finOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory save(ProductCategory productCategory);
}
