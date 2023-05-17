package com.example.mybatis_demo.model;

import lombok.Data;

import java.util.List;

// 普通实体类
@Data
public class UserInfo {
    // 这里的属性名一定要和数据表中的字段名一一对应, 否则查询返回时, 就会找不到这里的属性, 从而变成null
    private int id;
    private String name;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private String state;
    private List<ArticleInfo> artlist;
}