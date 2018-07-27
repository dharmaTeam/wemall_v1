package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsValuable {
    private Long id;
    private String goods_name;
    private ZuTu zuTu;
    private Double goods_price;
}
