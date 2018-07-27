package com.example.demo.controller;

import com.example.demo.bean.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by coldwarm on 2018/7/25.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/",produces="application/json;charset=UTF-8")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping(value = "/id",produces="application/json;charset=UTF-8")
    public Address findById(@RequestParam Long id){
        return addressService.findById(id);
    }

    @GetMapping(value = "/user_id",produces="application/json;charset=UTF-8")
    public List<Address> findByUser_id(@RequestParam Long user_id){
        return addressService.findByUserId(user_id);
    }

    @PostMapping(value = "/delete/id",produces="application/json;charset=UTF-8")
    public void updateDeleteStatus(@RequestParam Long id){
        addressService.updateDeleteStatus(id);
    }

    @PostMapping(value = "/save",produces="application/json;charset=UTF-8")
    public Address save(Address address){
        return addressService.save(address);
    }

    @GetMapping(value = "/areaId",produces="application/json;charset=UTF-8")
    public String AddressArea(@RequestParam Long areaId){
        return addressService.area(areaId);
    }
}
