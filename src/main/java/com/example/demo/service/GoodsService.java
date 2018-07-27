package com.example.demo.service;

import com.example.demo.bean.Goods;
import com.example.demo.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/26.
 */

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<Goods> findByGoodsNameLike(String goodsName, Long goods_store_id){
        goodsName = "%" + goodsName + "%";

        List<Goods> goodss = goodsDao.findByGoodsNameLike(goodsName, goods_store_id);

        return goodss;
    }
}
