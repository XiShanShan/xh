package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

        System.out.println("-------------------------");
        System.out.println("page:"+page);
        System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Article> articles = articleService.findByPage(page, rows);

        //总记录数
        Long totals = articleService.findTotals();
        System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", articles);
        return results;
    }


    @RequestMapping("/update")
    public @ResponseBody Map<String ,Object> update(Article article){
        //System.out.println("article"+article);
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            articleService.update(article);
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
            articleService.delete(id);
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
    Article queryOne(String id){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Article article = articleService.queryOne(id);
       // System.out.println("!!!!!!!!!!!!!!!!!!"+article);
        return  article;
    }
    //上传图片
    @RequestMapping("/save")
    public String save(MultipartFile file, HttpServletRequest request, Article article) throws IOException {
        //获取上传路径  相对路径 files    获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/article/img");
        article.setImgPath("back/article/img/"+file.getOriginalFilename());
        articleService.save(article);
        //上传
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        return null;
    }
}

