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

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/id")
    public Address findById(@RequestParam Long id){
        return addressService.findById(id);
    }

    @GetMapping("/user_id")
    public List<Address> findByUser_id(@RequestParam Long user_id){
        return addressService.findByUserId(user_id);
    }

    @PostMapping("/delete/id")
    public void updateDeleteStatus(@RequestParam Long id){
        addressService.updateDeleteStatus(id);
    }

    @PostMapping("/save")
    public Address save(Address address){
        return addressService.save(address);
    }

    @GetMapping("/areaId")
    public String AddressArea(@RequestParam Long areaId){
        return addressService.area(areaId);
    }
}
