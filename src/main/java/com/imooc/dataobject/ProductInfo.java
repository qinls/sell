package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * Created by Administrator on 2018/11/5.
 */
@Entity
@DynamicUpdate  // 动态自动更新时间
@Proxy(lazy = false)  // 懒加载设置为false
@Data
public class ProductInfo {

    @Id
    private String productId;
    //    名字
    private String productName;
    //    单价
    private BigDecimal productPrict;
    //    库存
    private Integer productStock;
    //    描述
    private String productDescription;
    //    小图
    private String productIcon;
    //    商品状态 0正常 1下架
    private Integer productStatus;
    //        类目编号
    private Integer categoryType;

}
