package com.baizhi.service;

import com.baizhi.entity.Gurn;

import java.util.List;

public interface GurnService {
    List<Gurn> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Gurn gurn);
    //修改
    void update(Gurn gurn);
    //删除
    void delete(String id);
    //查一个
    Gurn queryOne(String id);
    //查所有
    List<Gurn> findAll();
}
