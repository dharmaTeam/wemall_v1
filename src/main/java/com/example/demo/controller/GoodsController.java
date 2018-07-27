package com.example.demo.controller;

import com.example.demo.bean.Goods;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/26.
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/find")
    public List<Goods> find(
            @RequestParam String goodsName,
            @RequestParam Long goods_store_id
    ){
        List<Goods> goodss = goodsService.findByGoodsNameLike(goodsName, goods_store_id);

        return goodss;
    }
}
