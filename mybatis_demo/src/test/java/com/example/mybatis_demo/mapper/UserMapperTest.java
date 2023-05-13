package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 该注解表示当前单元测试运行在Spring Boot中
@Slf4j
class UserMapperTest {
    @Resource
//    @Autowired 由于UserMapper加了@Mapper注解(@Mapper来自Mybatis), 而且@Autowired是来自Spring,
//    而Spring不支持 MyBatis的@Mapper的, 所以这里可能会报错, 但这是误报, 可以
//    正常运行. 只有@Mapper会出现这个问题
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        Assertions.assertNotNull(userInfo);  // 断言
        System.out.println(userInfo);
    }
    @Test
    @Transactional  // 在单元测试中添加此注解, 表示在方法执行完回滚事务. 方法执行完会修改数据库中的内容(污染数据库)
    void update() {
        int result = userMapper.update(2, "ttt");
        Assertions.assertEquals(1, result);
    }

    @Test
    @Transactional
    void delete() {
        int res = userMapper.delete(2);
        Assertions.assertEquals(1, res);
    }

    @Test
    @Transactional
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sgy");
        userInfo.setPassword("123");
        userInfo.setPhoto("default.png");
        int res = userMapper.add(userInfo);
        Assertions.assertEquals(1, res);
    }

    @Test
    @Transactional
    void addGetId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("sgd");
        userInfo.setPassword("456");
        userInfo.setPhoto("default.png");
        int res = userMapper.addGetId(userInfo);
        Assertions.assertEquals(1, res);
        System.out.println("自增id: " + userInfo.getId());
    }

    @Test
    void getUserByFullName() {
        UserInfo userInfo = userMapper.getUserByFullName("admin");
        Assertions.assertNotNull(userInfo);  // 断言
        System.out.println(userInfo);
    }

    @Test
    void getOrderList() {
        List<UserInfo> userInfo = userMapper.getOrderList("desc");
        Assertions.assertNotNull(userInfo);  // 断言
        System.out.println(userInfo);
    }

    @Test
//    @Transactional
    void login() {
        String username = "admin";
        String password = "' or 1='1";
        UserInfo userInfo = userMapper.login(username, password);
        log.info("用户信息: " + userInfo);
    }


    @Test
    void getListByName() {
        String username = "a";
        List<UserInfo> list = userMapper.getListByName(username);
        log.info("用户列表: " + list);

    }
}