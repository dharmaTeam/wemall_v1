package com.example.demo.service;

import com.example.demo.bean.StoreInfo;
import com.example.demo.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zhumeng
 * @desc:
 **/
@Service
public class StoreService {
    @Autowired
    private StoreDao storeDao;



    public StoreInfo findStoreById(Long id){
        return storeDao.findStoreInfoById(id);
    }

}
