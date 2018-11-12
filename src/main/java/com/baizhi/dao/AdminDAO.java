package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDAO {
   //登陆
   Admin queryAdmin(Admin admin);
   //修改密码
   void update(Admin admin );
   //查询管理员
  Admin queryOne(String name);
}
