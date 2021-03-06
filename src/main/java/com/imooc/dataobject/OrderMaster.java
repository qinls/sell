package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 * Created by Administrator on 2018/11/6.
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone = "";
    private String buyerAddress;
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态 默认0新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态 默认0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;
}
