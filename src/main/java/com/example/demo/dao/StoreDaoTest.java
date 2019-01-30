package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.bean.StoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StoreDaoTest {

    @Autowired
    private StoreDao storeDao;


    @Test
    public void test(){
        StoreInfo s=storeDao.findStoreInfoById(32768L);
        log.info("================="+s.toString());
    }

}