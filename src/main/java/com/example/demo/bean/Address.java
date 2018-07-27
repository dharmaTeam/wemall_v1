package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Create by coldwarm on 2018/7/25.
 */
@Entity
@Table(name = "wemall_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private long id;
    private Date addTime;
    private boolean deleteStatus = false;
    private String area_info;
    private String mobile;
    private String telephone;
    private String trueName;
    private String zip;
    private Long area_id;
    private Long user_id;

}