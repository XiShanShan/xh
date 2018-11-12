package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {

    void update(User user);

    void  register(User user);

    boolean login(User user);
}
