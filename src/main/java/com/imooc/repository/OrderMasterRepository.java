package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/11/6.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    // 分页查询
    Page<OrderMaster> findOrderMasterByBuyerOpenid(String buyerOpenid, Pageable pageable);
}