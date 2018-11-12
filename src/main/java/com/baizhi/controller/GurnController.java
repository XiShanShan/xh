package com.baizhi.controller;

import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gurn")
public class GurnController {
    @Autowired
    private GurnService gurnService;
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

        System.out.println("-------------------------");
        System.out.println("page:"+page);
        System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Gurn> gurns = gurnService.findByPage(page, rows);

        //总记录数
        Long totals = gurnService.findTotals();
        System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", gurns);
        return results;
    }

    @RequestMapping("/delete")
    public @ResponseBody
    Map<String ,Object> delete(String id){
        //   System.out.println(id);
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            gurnService.delete(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/queryOne")
    public @ResponseBody
  Gurn queryOne(String id){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Gurn gurn = gurnService.queryOne(id);
        // System.out.println("!!!!!!!!!!!!!!!!!!"+gurn);
        return  gurn;
    }
    @RequestMapping("/save")
    public String save(MultipartFile file, HttpServletRequest request, Gurn gurn) throws IOException {
        //获取上传路径  相对路径 files    获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/gurn/img");
        gurn.setHeadPortrait("back/gurn/img/"+file.getOriginalFilename());
        gurnService.save(gurn);
        //上传
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        return null;
    }
    @RequestMapping("/update")
    public String update(MultipartFile file,HttpServletRequest request,Gurn gurn)throws IOException{
        String realPath =request.getSession().getServletContext().getRealPath("/back/gurn/img");
        gurn.setHeadPortrait("back/gurn/img/"+file.getOriginalFilename());
        System.out.println("!!!!!!!"+file);
        gurnService.update(gurn);
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        return null;
    }
}

