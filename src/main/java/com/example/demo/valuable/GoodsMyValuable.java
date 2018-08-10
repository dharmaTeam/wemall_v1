package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Create by coldwarm on 2018/8/10.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsMyValuable {
    private String goods_name;
    private ZuTu zuTu;
    private Double goods_price;
}
