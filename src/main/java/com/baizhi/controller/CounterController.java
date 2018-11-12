package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("counter")
public class CounterController {
    @Autowired
    private CounterService counterService;
    @RequestMapping("/findAll")

    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

        // System.out.println("-------------------------");
        //System.out.println("page:"+page);
        // System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Counter> counters = counterService.findByPage(page, rows);


        //总记录数
        Long totals = counterService.findTotals();
        // System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", counters);
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Counter counter){

        System.out.println("counter"+counter);

        Map<String,Object> results = new HashMap<String,Object>();
        try {
            counterService.save(counter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/update")
    public @ResponseBody Map<String ,Object> update(Counter counter){
        System.out.println("counter"+counter);
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            counterService.update(counter);
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
            counterService.delete(id);
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
    Counter queryOne(String id){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Counter counter= counterService.queryOne(id);
        System.out.println("!!!!!!!!!!!!!!!!!!"+counter);
        return  counter;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(String[] id){
        for (String s : id) {
            counterService.delete(s);
        }
    }

}
