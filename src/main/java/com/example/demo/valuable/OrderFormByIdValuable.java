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
}
