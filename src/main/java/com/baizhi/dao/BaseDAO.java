package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T> {
    //添加
    void save(T t);
    //修改
    void update(T t);
    //删除
    void delete(String id);
    //查一个
    T queryOne(String id);
    //查所有
    List<T> findAll();
    //分页
    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long findTotals();
}
