package com.example.demo.dao;

import com.example.demo.bean.StoreCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreCartDao extends JpaRepository<StoreCart,Long> {
    @Query("select p from StoreCart p where p.user_id=?1 and deleteStatus = 0")
    StoreCart findByUser_id(Long user_id);

    @Query("select id from StoreCart where user_id = ?1 and deleteStatus = 0")
    List<Long> findIdByUserId(Long user_id);
}
