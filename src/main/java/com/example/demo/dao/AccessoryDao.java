package com.example.demo.dao;

import com.example.demo.bean.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryDao extends JpaRepository<Accessory,Long> {

}
