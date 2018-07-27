package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "wemall_accessory")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accessory {
    @Id
    @GeneratedValue
    private Long id;
    private String addtime;
    private Integer deletestatus;
    private String ext;
    private Integer height;
    private String info;
    private String name;
    private String path;
    private Double size;
    private Integer width;
    private Long album_id;
    private Long user_id;
    private Long config_id;
}
