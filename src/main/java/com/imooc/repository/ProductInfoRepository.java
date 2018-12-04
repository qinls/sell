package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/11/5.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findProductInfosByProductStatus(Integer productStatus);

    List<ProductInfo> findProductInfoByProductStatus(Integer productStatus);
}
