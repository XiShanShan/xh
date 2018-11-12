package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //登陆
    @RequestMapping("/login")
    public String login(Admin admin,HttpServletRequest httpServletRequest, String enCode){
        HttpSession session = httpServletRequest.getSession();
        String validationCode = (String) session.getAttribute("validationCode");//获取验证码
        boolean login=adminService.login(admin);
        if(validationCode.equals(enCode)){
            if(login){
                session.setAttribute("adminName",admin.getName());
                return "redirect:/back/main/main.jsp";
            }else{
                return "redirect:/back/login.jsp";
            }
        }else {
            return "redirect:/back/login.jsp";
        }


    }
    //修改密码
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Admin admin,String oldPassword,HttpServletRequest httpServletRequest){
        Map<String ,Object> results=new HashMap<String ,Object>();
        HttpSession session=httpServletRequest.getSession();
        String name=(String) session.getAttribute("adminName");
        Admin queryOne=adminService.queryOne(name);
        if((queryOne.getPassword()).equals(oldPassword)){
            adminService.update(admin);
            results.put("success",true);
        }else{
            results.put("success",false);
        }
        return results;
    }



    //退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest httpServletRequest){
      HttpSession session= httpServletRequest.getSession();
        session.removeAttribute("adminName");
      return "redirect:/back/login.jsp";
    }

}
