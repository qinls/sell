package com.imooc.dataobject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/5.
 */
@Entity
@DynamicUpdate  // 动态自动更新时间
@Proxy(lazy = false)  // 懒加载设置为false
@Data
public class ProductCategory {
    //    类目
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    //    类目名字
    private String categoryName;

    //    类目编号
    private Integer categoryType;

    public ProductCategory() {
    }
    private Date createTime;
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}


