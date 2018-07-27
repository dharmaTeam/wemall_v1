package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "wemall_storecart")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreCart {
    @Id
    @GeneratedValue
    private Long id;
    private Date addtime;
    private boolean deletestatus;
    private String cart_session_id;
    private Double total_price;
    private Long store_id;
    private Long user_id;
    private Integer sc_status;
}
