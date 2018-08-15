package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "wemall_orderform")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date addtime;
    private Integer deletestatus;
    private Date finishtime;
    private Double goods_amount;
    private String invoice;
    private Integer invoicetype;
    private String msg;
    private String order_id;
    private Integer order_status;
    private Date paytime;
    private String pay_msg;
    private Double refund;
    private String refund_type;
    private String shipcode;

    private Date shiptime;
    private Double ship_price;
    private Double totalprice;
    private Long addr_id;
    private Long payment_id;
    private Long store_id;
    private Long user_id;
    private Integer auto_confirm_email;
    private Integer auto_confirm_sms;
    private String transport;
    private Long out_order_id;
    private Long ec_id;
    private Long ci_id;
    private String order_seller_intro;
    private String return_shipcode;
    private Long return_ec_id;
    private String return_content;
    private Date return_shiptime;
    private String order_type;

}
