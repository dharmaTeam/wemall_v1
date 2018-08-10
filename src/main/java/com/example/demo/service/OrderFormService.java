package com.example.demo.service;

import com.example.demo.bean.Accessory;
import com.example.demo.bean.Goods;
import com.example.demo.bean.OrderForm;
import com.example.demo.dao.AccessoryDao;
import com.example.demo.dao.GoodsDao;
import com.example.demo.dao.OrderFormDao;
import com.example.demo.valuable.GoodsMyValuable;
import com.example.demo.valuable.OrderFormValuable;
import com.example.demo.valuable.ZuTu;
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

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private AccessoryDao accessoryDao;

    public List<OrderForm> findAll(){
        return orderFormDao.findAll();
    }

    public List<OrderFormValuable> findByStore_idAndOrder_status(Long store_id,int order_status){

        List<OrderFormValuable> orderFormValuables = new ArrayList<>();
        List<OrderForm> orderForm = orderFormDao.findByStore_idAndOrder_status(store_id, order_status);
        for (OrderForm orderForm1 : orderForm){
            List<Long> goodsId = goodsService.findGoodsIdByOf_id(orderForm1.getId());
            List<GoodsMyValuable> goodsMyValuables=new ArrayList<>();
            for (Long id : goodsId){
                Goods goods=goodsDao.findById(id).orElse(new Goods());
                Accessory accessory=accessoryDao.findById(goods.getGoods_main_photo_id()).orElse(new Accessory());
                goodsMyValuables.add(new GoodsMyValuable(goods.getGoods_name(),new ZuTu(accessory.getPath(),accessory.getName(),accessory.getExt()),goods.getGoods_price()));
            }
            orderFormValuables.add(new OrderFormValuable(goodsMyValuables,orderForm1.getGoods_amount(),orderForm1.getOrder_status(),orderForm1.getId()));
        }
        return orderFormValuables;
    }
}
