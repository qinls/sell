package com.imooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductsStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/5.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository repository;

    @Override
    public Optional<ProductInfo> findOne(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findProductInfosByProductStatus(ProductsStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    // 测试分页 pagehelp
    public List<ProductInfo> findAll2(Integer page, Integer size) {
        PageHelper.startPage(1, 3);
        List<ProductInfo> all = repository.findAll();
        PageInfo pageInfo = new PageInfo(all);
        log.info("总共数：{}", pageInfo.getTotal());
        log.info("页数：{}", pageInfo.getPageNum());
        log.info("每页的对象：{}", pageInfo.getList());
        return pageInfo.getList();
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (!productInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo1 = productInfo.get();

            // 加库存
            Integer num = productInfo1.getProductStock() + cartDTO.getProductQuantity();
            productInfo1.setProductStock(num);
            repository.save(productInfo1);
        }
    }

    // 减库存
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (!productInfo.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo1 = productInfo.get();

            // 减库存
            Integer num = productInfo1.getProductStock() - cartDTO.getProductQuantity();
            if (num < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            // 库存入库
            productInfo1.setProductStock(num);
            repository.save(productInfo1);
        }
    }
}
