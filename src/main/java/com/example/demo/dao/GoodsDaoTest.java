package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.bean.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;


    @Test
    public void test() {
        Goods s = goodsDao.findGoodsByIdAndGoods_store_id(98507L,32782L);
        log.info("=================" + s.toString());
    }

}
