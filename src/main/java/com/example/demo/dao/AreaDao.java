package com.example.demo.dao;

import com.example.demo.bean.AddressArea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by coldwarm on 2018/7/27.
 */

public interface AreaDao extends JpaRepository<AddressArea,Long> {

}
