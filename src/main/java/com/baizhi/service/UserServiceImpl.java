package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public void update(User user) {
       userDAO.update(user);
    }


    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }


    public boolean login(User user) {
        User queryOne = userDAO.queryOne(user);
        if (queryOne != null) {
            return true;
        } else {
            return false;
        }
    }
}