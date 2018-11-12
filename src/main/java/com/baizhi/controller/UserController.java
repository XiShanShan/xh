package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/update")
    public @ResponseBody
    Map<String ,Object> update(User user){

        Map<String, Object> results = new HashMap<String, Object>();
        try {
            userService.update(user);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return null;
    }

    @RequestMapping("/login")
    public boolean login(User user){
     boolean login= userService.login(user);
     if(user!=null){
         return true;
     }else{
         return false;
     }
    }

}
