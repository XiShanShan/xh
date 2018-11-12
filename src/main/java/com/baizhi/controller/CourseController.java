package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll")

    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

        // System.out.println("-------------------------");
        //System.out.println("page:"+page);
        // System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Course> courses = courseService.findByPage(page, rows);
        //System.out.println("depts:"+depts);

        //总记录数
        Long totals = courseService.findTotals();
        // System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", courses);
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Course course){

        Map<String,Object> results = new HashMap<String,Object>();
        try {
            courseService.save(course);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/update")
    public @ResponseBody Map<String ,Object> update(Course course){
        System.out.println("course"+course);
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            courseService.update(course);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/delete")
    public @ResponseBody
    Map<String ,Object> delete(String id){
        //   System.out.println(id);
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            courseService.delete(id);
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
    Course queryOne(String id){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Course course = courseService.queryOne(id);
        System.out.println("!!!!!!!!!!!!!!!!!!"+course);
        return  course;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(String[] id){
        for (String s : id) {
            courseService.delete(s);
        }
    }

}
