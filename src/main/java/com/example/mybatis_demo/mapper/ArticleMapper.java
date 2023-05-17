package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    // 根据文章id获取文章
    public ArticleInfo getArticleById(@Param("id") Integer id);
}
