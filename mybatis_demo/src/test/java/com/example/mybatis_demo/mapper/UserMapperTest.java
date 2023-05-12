package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 该注解表示当前单元测试运行在Spring Boot中
class UserMapperTest {
    @Resource
//    @Autowired 由于UserMapper加了@Mapper注解(@Mapper来自Mybatis), 而且@Autowired是来自Spring,
//    而Spring不支持 MyBatis的@Mapper的, 所以这里可能会报错, 但这是误报, 可以
//    正常运行. 只有@Mapper会出现这个问题
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(2);
        Assertions.assertNotNull(userInfo);  // 断言
        System.out.println(userInfo);
    }
}