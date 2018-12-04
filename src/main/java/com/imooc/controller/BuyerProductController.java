package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.CategoryService;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by Administrator on 2018/11/5.
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    // 这里可以给默认值
    @GetMapping("/getBydddd")
    public ResultVO list2(@RequestParam("openid") String openid,
                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("openid 不能为空");
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        return null;
    }

    @GetMapping("/list")
    public ResultVO list() {
        // 1 查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2 查询商品类目（一次查询）
        List<Integer> categoriesTypeList = new ArrayList<>();

        // 方法1
//        for (ProductInfo productInfo : productInfoList) {
//            categoriesTypeList.add(productInfo.getCategoryType());
//        }

        // 方法2 lambda
        categoriesTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        //查询出来的类目
        List<ProductCategory> productCategoriesList = categoryService.
                findProductCategoriesByCategoryTypeIn(categoriesTypeList);


        // 数据拼接

        // 商品类目
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoriesList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                // 类型相同的放一个类目下
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    // 对象属性拷贝
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            // 外层封装
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    @GetMapping("/getOne")
    public ResultVO getOne() {
//        OrderDTO dto = orderService.findOne("1541517338020890523");
        OrderDTO dto = orderService.findOne("33");
        return ResultVOUtil.success(dto);
    }
}
