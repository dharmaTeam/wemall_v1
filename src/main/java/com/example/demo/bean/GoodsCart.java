package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wemall_goodscart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCart {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date addTime;
    private  boolean deleteStatus;
    private  Integer count;
    private  double price;
    private  String spec_info;
    private  Long goods_id;
    private  Long of_id;
    private  String cart_type;
    private  Long sc_id;


}
