package com.example.demo.dao;

import com.example.demo.bean.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderFormDao extends JpaRepository<OrderForm, Long> {

    @Query(value = "select p from OrderForm p where store_id = ?1 and order_status = ?2")
    List<OrderForm> findByStore_idAndOrder_status(Long store_id, int order_status);

    @Query(value = "select p from OrderForm p where id = ?1")
    List<OrderForm> findByOf_id(Long id);

    @Query(value = "select p.addr_id from OrderForm p where p.id = ?1")
    Long findAddr_idByOf_id(Long id);

    @Query(value = "select p from OrderForm p where p.store_id = ?1")
    List<OrderForm> findByStore_id(Long Store_id);

    @Query(value = "select p from OrderForm p where p.store_id=?1 and p.finishtime between ?2 and ?3")
    List<OrderForm> findByFinishtimeBetween(Long storeId, Date date1, Date date2);

    @Query(value = "select p from OrderForm p  where p.store_id=?1 and p.finishtime is not null")
    List<OrderForm> findFinish(Long storeId);


    @Query(value = "select p from OrderForm p where p.store_id=?1 and p.order_status=?2")
    List<OrderForm> findByOrder_status(Long storeId, Integer order_status);


    @Query(value = "select p.shipcode from OrderForm  p where p.id=?1")
    String  findShipCodeById(Long id);

    @Query(value = "select p.ec_id from OrderForm  p where p.id=?1")
    Long  findEcIdById(Long id);


}
