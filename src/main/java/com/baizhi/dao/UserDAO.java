package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO{

    void save(User user);

    void update(User user);

    User queryOne(User user);


}
