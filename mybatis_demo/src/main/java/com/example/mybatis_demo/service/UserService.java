package com.example.mybatis_demo.service;

import com.example.mybatis_demo.mapper.UserMapper;
import com.example.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

//    public int update(Integer id, String username);

}

