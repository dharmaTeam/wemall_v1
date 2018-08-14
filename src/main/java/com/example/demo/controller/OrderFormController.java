package com.example.demo.controller;

import com.example.demo.bean.OrderForm;
import com.example.demo.service.OrderFormService;
import com.example.demo.valuable.OrderFormByIdValuable;
import com.example.demo.valuable.OrderFormValuable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by coldwarm on 2018/8/10.
 */

@RestController
@RequestMapping("/orderform")
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;

    @GetMapping("/findAll")
    public List<OrderForm> findAll(@RequestParam Long store_id){
        return orderFormService.findAll(store_id);
    }

    @GetMapping("/findByStore_idAndOrder_status")
    public List<OrderFormValuable> findByStore_idAndOrder_status(@RequestParam Long store_id, @RequestParam int order_status){
        return orderFormService.findByStore_idAndOrder_status(store_id, order_status);
    }

    @GetMapping("findByOf_id")
    public List<OrderFormByIdValuable> findByOf_id(@RequestParam Long of_id){
        return orderFormService.findByOf_id(of_id);
    }
}
