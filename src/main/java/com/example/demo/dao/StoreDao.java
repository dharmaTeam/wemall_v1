package com.example.demo.dao;

import com.example.demo.bean.StoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:zhumeng
 * @desc:
 **/
public interface StoreDao extends JpaRepository<StoreInfo,Long> {

    StoreInfo findStoreInfoById(Long id);
}
