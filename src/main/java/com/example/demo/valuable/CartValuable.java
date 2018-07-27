package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartValuable {
    private Long goods_id;
    private ZuTu zuTu;
    private String goods_name;
    private Double goods_price;
    private Integer last;
    private Integer number;
}
