package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.model.UserInfo;
import com.example.mybatis_demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 查询
    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {
        if (null == id) {
            return null;
        }

        return userService.getUserById(id);
    }

    // update
//    @RequestMapping("/update")
//    public int update(Integer id, String username) {
//
//    }

}
