package com.example.demo.valuable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsMoreValuable {
    private Long id;
    private String goods_name;
    private List<ZuTu> zuTu;
    private Double goods_price;
    private String goods_property;
    private String goods_details;
}

