package com.example.demo.service;

import com.example.demo.bean.ExpressCompany;
import com.example.demo.dao.ExpressCompanyDao;
import com.example.demo.dao.OrderFormDao;
import com.example.demo.util.HttpRequest;
import com.example.demo.util.MD5;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class ExpressCompanyService {
    @Autowired
    ExpressCompanyDao expressCompanyDao;

    @Autowired
    OrderFormDao orderFormDao;

    public String findCompanyMarkById(Long id) {
        ExpressCompany result = expressCompanyDao.findOneByEcId(orderFormDao.findEcIdById(id));
        return result.getCompany_mark();
    }

    public String findShipCodeById(Long id) {
        return orderFormDao.findShipCodeById(id);
    }

    public JSONObject kuaidichaxun(String com, String num) {

        String param = "{\"com\":\"" + com + "\",\"num\":\"" + num + "\"}";
        log.info("s={}", param);
        String customer = "6A559F94707AEE0B0CA25ECF53F4EC02";
        String key = "VxjdQuuB9585";
        String sign = MD5.encode(param + key + customer);
        HashMap params = new HashMap();
        params.put("param", param);
        params.put("sign", sign);
        params.put("customer", customer);
        String resp = null;
        try {
            resp = HttpRequest.postData("http://poll.kuaidi100.com/poll/query.do", params, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject json = JSONObject.fromObject(resp);//将java对象转换为json对象

        return json;
    }
}
