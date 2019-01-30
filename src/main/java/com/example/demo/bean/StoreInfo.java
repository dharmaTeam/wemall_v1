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
 * @author:zhumeng
 * @desc:
 **/
@Entity
@Table(name = "wemall_store")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreInfo {

    @Id
    @GeneratedValue
    private Long id;
    private Date addTime;


}
