package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Chapter chapter);

    //修改
    void update(Chapter chapter);

    //删除
    void delete (String id);

    //查一个
    Chapter queryOne(String id);

    //查所有
    List<Chapter> findAll();

}
