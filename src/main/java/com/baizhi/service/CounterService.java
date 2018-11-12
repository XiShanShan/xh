package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService {
    List<Counter> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Counter counter);
    //修改
    void update(Counter counter);
    //删除
    void delete(String id);
    //查一个
    Counter queryOne(String id);
    //查所有
    List<Counter> findAll();


}
