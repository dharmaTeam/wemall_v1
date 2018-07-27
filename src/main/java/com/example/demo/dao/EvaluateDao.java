package com.example.demo.dao;

import com.example.demo.bean.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluateDao extends JpaRepository<Evaluate,Long> {
    @Query("select p from Evaluate p where p.evaluate_goods_id=?1")
    List<Evaluate> findByEvaluate_goods_id(Long evaluate_goods_id);
}
