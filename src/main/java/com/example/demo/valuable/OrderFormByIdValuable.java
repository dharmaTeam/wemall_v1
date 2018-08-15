package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
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
    private String user_address;
    private String order_id;
    private Double totalPrice;
    private Date addTime;
    private Date finfishTime;
    private Date payTime;
    private Date shipTime;

    public OrderFormByIdValuable(List<GoodsMyValuable> goodsMyValuables, Double goods_amount, String status, String order_id,Double totalPrice,Date addTime,Date finfishTime,Date payTime,Date shipTime) {
        this.goodsMyValuables = goodsMyValuables;
        this.goods_amount = goods_amount;
        this.status = status;
        this.order_id = order_id;
        this.totalPrice = totalPrice;
        this.addTime = addTime;
        this.finfishTime = finfishTime;
        this.payTime = payTime;
        this.shipTime = shipTime;
    }

}
