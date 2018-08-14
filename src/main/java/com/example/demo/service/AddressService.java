package com.example.demo.service;

import com.example.demo.bean.Address;
import com.example.demo.bean.AddressArea;
import com.example.demo.dao.AddressDao;
import com.example.demo.dao.AreaDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by coldwarm on 2018/7/25.
 */

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AreaDao areaDao;

    //传入地址id
    public String area(Long id){
        Long areaId = addressDao.findByIdAndDeleteStatusEquals(id,false).getArea_id();
        if (areaId == null){
            return "";
        }
        AddressArea addressArea = areaDao.findById(areaId).orElse(new AddressArea());

        int level = addressArea.getLevel();
        String area_2 = addressArea.getAreaName();

        if (level == 2){
            AddressArea addressArea1 = areaDao.findById(addressArea.getParent_id()).orElse(new AddressArea());
            String area_1 = addressArea1.getAreaName();
            if (addressArea1.getLevel() == 1){
                    String area_0 = areaDao.findById(addressArea1.getParent_id()).orElse(new AddressArea()).getAreaName();
                    return area_0 + area_1 + area_2;
            }
        }else if (level == 1){
            String area_1 = areaDao.findById(addressArea.getParent_id()).orElse(new AddressArea()).getAreaName();
            return area_1 + area_2;
        }
        return area_2;
    }
    public List<Address> findAll(){
        return addressDao.findAll();
    }
    public List<Address> findByUserId(Long user_id){
        for (Address address : addressDao.finddByUser_id(user_id)) {
            if (address.isDeleteStatus() == false) {
                List<Address> addresses = addressDao.findWithUser_id(user_id);
                List<Address> addresses1 = new ArrayList<>();
                for (Address address2 : addresses) {
                    Address address1 = new Address();
                    BeanUtils.copyProperties(address2, address1);

                    String addressArea = area(address1.getId()) + address1.getArea_info();
                    address1.setArea_info(addressArea);
                    addresses1.add(address1);
                }
                return addresses1;
            }else {
                return null;
            }
        }
        return null;
    }

    public Address findById(Long id){
       if (addressDao.findByIdd(id).isDeleteStatus() == false) {
           Address address = addressDao.findByIdAndDeleteStatusEquals(id, false);
           Address address1 = new Address();
           BeanUtils.copyProperties(address, address1);

           String addressArea = area(id) + address1.getArea_info();
           address1.setArea_info(addressArea);
           return address1;
       }else {
           return null;
       }
    }


    public void updateDeleteStatus(Long id){
        addressDao.updateDeleteStatus(id);
    }

    public Address save(Address address){
        address.setAddTime(new Date());

        return addressDao.save(address);
    }
}
