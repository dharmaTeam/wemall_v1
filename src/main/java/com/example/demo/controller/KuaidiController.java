package com.example.demo.controller;

import com.example.demo.service.ExpressCompanyService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kuaidi")
public class KuaidiController {

    @Autowired
    ExpressCompanyService expressCompanyService;

    @GetMapping("/info")
    public JSONObject getInfo(@RequestParam("orderId") Long orderId) {
        return expressCompanyService.kuaidichaxun(expressCompanyService.findCompanyMarkById(orderId),
                expressCompanyService.findShipCodeById(orderId));
    }
}
