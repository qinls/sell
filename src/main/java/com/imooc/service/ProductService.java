package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/5.
 */
public interface ProductService {
    Optional<ProductInfo> findOne(String productId);

    /**
     * 在上架的商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查所有的
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
