package com.example.demo.dao;

import com.example.demo.bean.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderFormDao extends JpaRepository<OrderForm,Long>{

     @Query(value = "select p from OrderForm p where store_id = ?1 and order_status = ?2")
    List<OrderForm> findByStore_idAndOrder_status(Long store_id,int order_status);
}
