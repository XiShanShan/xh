package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    //管理员登陆
    public boolean login(Admin admin){
        Admin queryAdmin=adminDAO.queryAdmin(admin);
        if(queryAdmin!=null){
            return true;
        }else{
            return false;
        }
    }
    //修改密码
    public void update(Admin admin){

        adminDAO.update(admin);
    }

    //查询单个
    public Admin queryOne(String name){

        return adminDAO.queryOne(name);
    }
}
