package com.example.demo.dao;

import com.example.demo.bean.ExpressCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpressCompanyDao extends JpaRepository<ExpressCompany,Long> {

    @Query(value = "select p from ExpressCompany p where p.id=?1")
    ExpressCompany findOneByEcId(Long ecId);

}
