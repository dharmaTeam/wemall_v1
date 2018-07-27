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
 * Create by coldwarm on 2018/7/27.
 */
@Entity
@Table(name = "wemall_area")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressArea {
    @Id
    @GeneratedValue
    private Long id;
    private Date addTime;
    private boolean deleteStatus;
    private String areaName;
    private int level;
    private int sequence;
    private Long parent_id;
    private boolean common;
}
