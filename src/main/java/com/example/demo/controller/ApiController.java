package com.example.demo.controller;

import com.example.demo.bean.Goods;
import com.example.demo.service.GoodsService;
import com.example.demo.valuable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class ApiController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods") //商品 id 名字 主图 价格
    public List<GoodsValuable> find(@RequestParam Long goods_store_id){
       return goodsService.find(goods_store_id);
    }

   @GetMapping("/goods/id")
    public GoodsMoreValuable find2(@RequestParam Long id){
        return goodsService.find2(id);
   }

   @GetMapping("/goods/comment/id")
    public EvaluableValuable find3(@RequestParam Long id){
        return goodsService.find3(id);
   }

   @GetMapping("/cart")
    public List<CartValuable> find4(@RequestParam Long user_id){
       return goodsService.find4(user_id);
   }

   @GetMapping("/addToCart")
    public void addToCart(@RequestParam Long user_id,@RequestParam Long goods_id,@RequestParam String spec_info){
        goodsService.addToCart(user_id, goods_id, spec_info);
   }

   @GetMapping("/submit")
    public int submit(@RequestParam Long user_id,@RequestParam Long addr_id){
       return goodsService.submit(user_id, addr_id);
   }

   @GetMapping("/delAndAdd")
    public int delAndAdd(@RequestParam Long user_id,@RequestParam Long goods_id,@RequestParam Integer status){
          return goodsService.delAndAdd(user_id, goods_id, status);
   }
    @GetMapping("/goods/like") //商品 id 名字 主图 价格
    public List<GoodsValuable> findLike(@RequestParam Long goods_store_id,@RequestParam String word){
       return goodsService.findLike(goods_store_id, word);
    }
}
