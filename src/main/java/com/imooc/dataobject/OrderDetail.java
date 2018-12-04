package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.soap.SAAJResult;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情
 * Created by Administrator on 2018/11/6.
 */
@Entity
@Data
@DynamicUpdate  // 动态自动更新时间
@DynamicInsert
public class OrderDetail {

    @Id
    private String detailId;

    // 订单ID
    private String orderId;

    // 商品ID
    private String productId;

    // 商品名称
    private String productName;

    // 商品价格
    private BigDecimal productPrict;

    // 商品数量
    private Integer productQuantity;

    // 商品小图
    private String productIcon;

    private Date createTime;
    private Date updateTime;
}
