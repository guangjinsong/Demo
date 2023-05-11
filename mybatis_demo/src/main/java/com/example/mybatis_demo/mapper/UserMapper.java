package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public UserInfo getUserById(@Param("id") Integer id); // @Param("id"): SQL中的id, Integer id: 参数id
}
