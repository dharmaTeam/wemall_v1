package com.example.demo.dao;

import com.example.demo.bean.GoodsPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsPhotoDao extends JpaRepository<GoodsPhoto,Long> {
    @Query("select g from GoodsPhoto g where g.goods_id=?1")
    List<GoodsPhoto> findByGoods_id(Long goods_id);
    @Query("select g.photo_id from GoodsPhoto g where g.goods_id=?1")
    List<Long> findPhoto_idByGoods_id(Long goods_id);
}
