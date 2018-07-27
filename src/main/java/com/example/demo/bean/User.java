package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "wemall_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private Date addtime;
    private  boolean deletestatus;
    private String MSN;
    private String QQ;
    private String WW;
    private String address;
    private Double availablebalance;
    private Date birthday;
    private String email;
    private Double freezeblance;
    private Integer gold;
    private Integer integral;
    private Date lastlogindate;
    private String lastloginip;
    private Integer logincount;
    private String logindate;
    private String loginip;
    private String mobile;
    private  String password;
    private Integer report;
    private Integer sex;
    private Integer status;
    private String telephone;
    private String truename;
    private String username;
    private String userrole;
    private Integer user_credit;
    private Long photo_id;
    private Long store_id;
    private String qq_openid;
    private  String sina_openid;
    private String store_quick_menu;
    private Long parent_id;
    private Integer years;
    private Long area_id;

}
