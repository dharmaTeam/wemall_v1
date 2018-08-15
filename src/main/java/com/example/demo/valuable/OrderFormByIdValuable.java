package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Create by coldwarm on 2018/8/11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFormByIdValuable {
    private List<GoodsMyValuable> goodsMyValuables;
    private Double goods_amount;
    private String status;
    private String userName;
    private String userTelephone;
    private String mobile;
    private String user_address;
    private String order_id;
    private Double totalPrice;
    private String addTime;
    private String finishTime;
    private String payTime;
    private String shipTime;
    private String shipCode;


    public OrderFormByIdValuable(List<GoodsMyValuable> goodsMyValuables, Double goods_amount,
                                 String status,String userName,String userTelephone,String mobile,
                                 String order_id,Double totalPrice,String addTime,String finishTime,
                                 String payTime,String shipTime,String shipCode) {
        this.goodsMyValuables = goodsMyValuables;
        this.goods_amount = goods_amount;
        this.status = status;
        this.order_id = order_id;
        this.totalPrice = totalPrice;
        this.addTime = addTime;
        this.finishTime = finishTime;
        this.payTime = payTime;
        this.shipTime=shipTime;
        this.shipCode=shipCode;
        this.userName = userName;
        this.userTelephone = userTelephone;
        this.mobile = mobile;
    }

}
