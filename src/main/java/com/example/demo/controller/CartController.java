package com.example.demo.controller;

import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by coldwarm on 2018/7/26.
 */

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/deleteGoods")
    public void deleteGoods(
            @RequestParam Long userId,
            @RequestParam Long goodsId
    ){
        cartService.deleteByUserIdAndGoodsId(userId, goodsId);
    }
}
