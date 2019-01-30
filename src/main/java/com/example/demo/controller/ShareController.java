package com.example.demo.controller;

import com.example.demo.bean.Goods;
import com.example.demo.bean.StoreInfo;
import com.example.demo.service.GoodsService;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhumeng
 * @desc:
 **/
@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;


    @GetMapping("/store")
    public StoreInfo findStore(@RequestParam Long store_id) {
        return storeService.findStoreById(store_id);
    }

    @GetMapping("/goods")
    public Goods findGoods(@RequestParam Long goods_id,@RequestParam Long store_id) {
        return goodsService.findGoodsByIdAndGoodsStoreId(goods_id,store_id);
    }


}
