package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuDAO extends BaseDAO<Menu>{
    @Override
    List<Menu> findAll();

}
