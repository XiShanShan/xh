package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Article article);
    //修改
    void update(Article article);
    //删除
    void delete(String id);
    //查一个
    Article queryOne(String id);
    //查所有
    List<Article> findAll();
}

