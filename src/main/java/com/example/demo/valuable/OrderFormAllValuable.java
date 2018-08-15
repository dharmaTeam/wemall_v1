package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.metadata.aggregated.rule.VoidMethodsMustNotBeReturnValueConstrained;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;
import java.util.List;

/**
 * Create by coldwarm on 2018/8/14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFormAllValuable {
    private List<GoodsMyValuable> goodsMyValuables;
    private Double goods_amount;
    private String status;
    private String user_address;
    private String order_id;
    private Long of_id;
    private Double totalPrice;

    public OrderFormAllValuable(List<GoodsMyValuable> goodsMyValuables, Double goods_amount, String status, String order_id, Long of_id, Double totalPrice) {
        this.goodsMyValuables = goodsMyValuables;
        this.goods_amount = goods_amount;
        this.status = status;
        this.order_id = order_id;
        this.of_id = of_id;
        this.totalPrice = totalPrice;
    }


}
