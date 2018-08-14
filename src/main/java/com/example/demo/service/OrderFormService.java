package com.example.demo.service;

import com.example.demo.bean.Accessory;
import com.example.demo.bean.Goods;
import com.example.demo.bean.OrderForm;
import com.example.demo.dao.AccessoryDao;
import com.example.demo.dao.AddressDao;
import com.example.demo.dao.GoodsDao;
import com.example.demo.dao.OrderFormDao;
import com.example.demo.valuable.GoodsMyValuable;
import com.example.demo.valuable.OrderFormByIdValuable;
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

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AddressService addressService;

    public List<OrderForm> findAll(Long store_id){
        return orderFormDao.findByStore_id(store_id);
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

    public List<OrderFormByIdValuable> findByOf_id(Long of_id){
        List<OrderFormByIdValuable> orderFormByIdValuables = new ArrayList<>();
        List<OrderForm> orderForms = orderFormDao.findByOf_id(of_id);
        for (OrderForm orderForm : orderForms){
            List<Long> goodsId = goodsService.findGoodsIdByOf_id(orderForm.getId());
            List<GoodsMyValuable> goodsMyValuables=new ArrayList<>();
            for (Long l : goodsId){
                Goods goods = goodsDao.findById(l).orElse(new Goods());
                Accessory accessory = accessoryDao.findById(goods.getGoods_main_photo_id()).orElse(new Accessory());
                goodsMyValuables.add(new GoodsMyValuable(goods.getGoods_name(),new ZuTu(accessory.getPath(),accessory.getName(),accessory.getExt()),goods.getGoods_price()));
            }
            Long addr_id = orderFormDao.findAddr_idByOf_id(of_id);
            String address = addressService.area(addr_id) + addressDao.findByIdAndDeleteStatusEquals(addr_id,false).getArea_info();
            orderFormByIdValuables.add(new OrderFormByIdValuable(goodsMyValuables,orderForm.getGoods_amount(),orderForm.getOrder_status(),address,orderForm.getOrder_id()));
        }
        return orderFormByIdValuables;
    }
}
