package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询 根据用户id查询用户名
    public UserInfo getUserById(@Param("id") Integer id); // @Param("id"): xml中的参数id, Integer id: 参数id

    // 查询 根据全名查询用户
    public UserInfo getUserByFullName(@Param("username") String name);

    // 获取列表, 根据创建时间进行倒序或正序
    public List<UserInfo> getOrderList(@Param("order") String order);

    // 修改 根据id修改用户名
    // 返回值是指受影响的行数
    public int update(@Param("id") Integer id, @Param("name") String username);

    // 删除 根据id删除用户名
    // 返回值是指受影响的行数
    public int delete(@Param("id") Integer id);

    // 添加用户,并返回受影响的行数
    public int add(UserInfo userInfo);

    // 添加用户, 并返回受影响的行数和自增ID
    public int addGetId(UserInfo userInfo);

    // 登录功能
    public UserInfo login(@Param("username") String username, @Param("password") String password);

    // 模糊查询 根据用户名进行模糊查询
    public List<UserInfo> getListByName(@Param("username") String username);

    // 一对多 多表查询
    // 查询用户及发表的所有文章, 根据用户id
    public UserInfo getUserAndArticleByUid(@Param("uid") Integer uid);
}
