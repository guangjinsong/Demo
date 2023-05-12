package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 查询 根据用户id查询用户名
    public UserInfo getUserById(@Param("id") Integer id); // @Param("id"): xml中的参数id, Integer id: 参数id

    // 修改 根据id修改用户名
    // 返回值是指受影响的行数
    public int update(@Param("id") Integer id, @Param("name") String username);

    // 删除 根据id删除用户名
    // 返回值是指受影响的行数
    public int delete(@Param("id") Integer id);
}
