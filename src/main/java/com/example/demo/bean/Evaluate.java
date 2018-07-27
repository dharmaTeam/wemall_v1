package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wemall_evaluate")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluate {
    @Id
    @GeneratedValue
    private Long id;
    private Date addtime;
    private  Integer deletestatus;
    private  String evaluate_admin_info;
    private Integer evaluate_buyer_val;
    private  String evaluate_info;
    private  String evaluate_seller_info;
    private String evaluate_seller_time;
    private Integer evaluate_seller_val;
    private  Integer evaluate_status;
    private String evaluate_type;
    private String goods_spec;
    private Long evaluate_goods_id;
    private Long evaluate_seller_user_id;
    private Long evaluate_user_id;
    private Long of_id;
    private Double description_evaluate;
    private  Double service_evaluate;
    private Double ship_evaluate;
}
