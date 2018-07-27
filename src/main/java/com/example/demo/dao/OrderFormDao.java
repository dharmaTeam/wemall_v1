package com.example.demo.dao;

import com.example.demo.bean.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFormDao extends JpaRepository<OrderForm,Long>{

}
