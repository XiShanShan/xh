package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findByPage(Integer page, Integer rows);
    Long findTotals();

    //添加
    void save(Course course);

    //修改
    void update(Course course);

    //删除
    void delete (String id);

    //查一个
   Course queryOne(String id);

    //查所有
    List<Course> findAll();


}
