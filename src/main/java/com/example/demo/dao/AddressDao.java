package com.example.demo.dao;

import com.example.demo.bean.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Create by coldwarm on 2018/7/25.
 */

public interface AddressDao extends JpaRepository<Address,Long> {

    Address findByIdAndDeleteStatusEquals(Long id, boolean deleteStatus);

    @Query(value = "select  p from Address p where p.id = ?1")
    Address findByIdd(Long id);

    @Query(value = "select p from Address p where p.user_id = ?1 and deleteStatus = 0")
    List<Address> findWithUser_id(Long user_id);

    @Query(value = "select p from Address p where p.user_id = ?1")
    List<Address> finddByUser_id(Long user_id);

    @Modifying
    @Query(value = "update Address set deleteStatus=1 where id = ?1")
    void updateDeleteStatus(Long id);


}
