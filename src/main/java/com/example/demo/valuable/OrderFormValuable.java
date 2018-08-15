package com.example.demo.valuable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Create by coldwarm on 2018/8/10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFormValuable {
    private List<GoodsMyValuable> goodsMyValuables;
    private Double goods_amount;
    private String status;
    private Long of_id;
    private Double totalPrice;
}
