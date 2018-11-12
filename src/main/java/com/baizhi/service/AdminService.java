package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    //登陆
    boolean login(Admin admin);
    //修改
    void update (Admin admin);
    //查询单个
    Admin queryOne(String name);
}
