package com.example.demo.controller;

import com.example.demo.bean.OrderForm;
import com.example.demo.dao.OrderFormDao;
import com.example.demo.service.OrderFormService;
import com.example.demo.valuable.OrderFormAllValuable;
import com.example.demo.valuable.OrderFormByIdValuable;
import com.example.demo.valuable.OrderFormValuable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by coldwarm on 2018/8/10.
 */

@RestController
@RequestMapping("/orderform")
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private OrderFormDao orderFormDao;

    @GetMapping("/findAll")
    public List<OrderFormAllValuable> findAll(@RequestParam Long store_id) {
        return orderFormService.findAll(store_id);
    }

    @GetMapping("/findByStore_idAndOrder_status")
    public List<OrderFormValuable> findByStore_idAndOrder_status(@RequestParam Long store_id, @RequestParam int order_status) {
        return orderFormService.findByStore_idAndOrder_status(store_id, order_status);
    }

    @GetMapping("/findByOf_id")
    public List<OrderFormByIdValuable> findByOf_id(@RequestParam Long of_id) {
        return orderFormService.findByOf_id(of_id);
    }

    @GetMapping("/findAllPriceByDateAndDataAndStoreId")
    public Map findAllPriceByDateAndStoreId(@RequestParam Long storeId,@RequestParam String  date1, @RequestParam String  date2) throws ParseException {
        Double allPrice=0.0;
        List<OrderForm> orderForms=orderFormService.findBetweenOrderForm(storeId,date1,date2);
        for(OrderForm s:orderForms){
                allPrice+=s.getTotalprice();
        }
//        JSONObject myJson = JSONObject.fromObject(jsonMessage);
//        List map=new ArrayList();
//        map.add(allPrice);
        Double value =new BigDecimal(allPrice).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        Map map=new HashMap();

        map.put("allPrice",value);
        return map;
    }

    @GetMapping("/findAllPriceByStoreId")
    public Map<String ,Double> findAllPriceByStoreId(@RequestParam Long storeId){
        Double allPrice=0.0;
        List<OrderForm> orderForms=orderFormDao.findFinish(storeId);
        for(OrderForm s:orderForms){
            allPrice+=s.getTotalprice();
        }
        Map map=new HashMap();
        Double value =new BigDecimal(allPrice).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        map.put("allPrice",value);
        return map;
    }

    @GetMapping("/findAllPriceByOrderStatusAndStoreId")
    public Map findAllPriceByOrderStatusAndStoreId(@RequestParam Long storeId,@RequestParam Integer orderStatus){
        Double allPrice=0.0;
        List<OrderForm> orderForms=orderFormDao.findByOrder_status(storeId,orderStatus);
        for(OrderForm s:orderForms){
            allPrice+=s.getTotalprice();
        }
        Map map=new HashMap();
        Double value =new BigDecimal(allPrice).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        map.put("allPrice",value);
        return map;
    }

}
