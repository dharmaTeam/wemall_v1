package com.example.demo.service;

import com.example.demo.dao.GoodsCartDao;
import com.example.demo.dao.StoreCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Create by coldwarm on 2018/7/26.
 */

@Service
public class CartService {
    @Autowired
    private StoreCartDao storeCartDao;
    @Autowired
    private GoodsCartDao goodsCartDao;

    @Transactional
    public void deleteByUserIdAndGoodsId(Long userId, Long goodsId){
        List<Long> scIds = storeCartDao.findIdByUserId(userId);

        goodsCartDao.deleteByScIdAndGoodsId(scIds, goodsId);
    }
}
