package com.example.demo.service;

import com.example.demo.bean.OrderForm;
import com.example.demo.dao.OrderFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by coldwarm on 2018/8/10.
 */
@Service
public class OrderFormService {

    @Autowired
    private OrderFormDao orderFormDao;

    public List<OrderForm> findAll(){
        return orderFormDao.findAll();
    }

    public List<OrderForm> findByStore_idAndOrder_status(Long store_id,int order_status){
//         List<OrderForm> orderForms = orderFormDao.findByStore_idAndOrder_status(store_id, order_status);
//         List<OrderForm> orderForms1 = new ArrayList<>();
//         for (OrderForm orderForm : orderForms){
//             OrderForm orderForm1 = new OrderForm();
//             orderForm1.setAddr_id(orderForm.getAddr_id());
//         }
        return orderFormDao.findByStore_idAndOrder_status(store_id, order_status);
    }
}
