package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("select p from User p where p.wx_openid = ?1")
    User findUserByOpenid(String openid);
}
