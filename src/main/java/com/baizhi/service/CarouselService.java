package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    List<Carousel> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Carousel carousel);
    //修改
    void update(Carousel carousel);
    //删除
    void delete(String id);
    //查一个
    Carousel queryOne(String id);
    //查所有
    List<Carousel> findAll();

}
