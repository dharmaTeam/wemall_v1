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
    private Integer status;
    private String user_address;
    private String order_id;

    public OrderFormByIdValuable(List<GoodsMyValuable> goodsMyValuables, Double goods_amount, Integer status, String order_id) {
        this.goodsMyValuables = goodsMyValuables;
        this.goods_amount = goods_amount;
        this.status = status;
        this.order_id = order_id;
    }
}
