package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
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
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

         System.out.println("-------------------------");
         System.out.println("page:"+page);
         System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Carousel> carousels = carouselService.findByPage(page, rows);
        //System.out.println("depts:"+depts);

        //总记录数
        Long totals = carouselService.findTotals();
        // System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", carousels);
        return results;
    }


    @RequestMapping("/update")
    public @ResponseBody Map<String ,Object> update(Carousel carousel){

        Map<String, Object> results = new HashMap<String, Object>();
        try {
            carouselService.update(carousel);
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
            carouselService.delete(id);
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
    Carousel queryOne(String id){

       Carousel carousel = carouselService.queryOne(id);
        System.out.println("!!!!!!!!!!!!!!!!!!"+carousel);
        return  carousel;
    }
    //上传图片
    @RequestMapping("/save")
    public String save(MultipartFile file, HttpServletRequest request, Carousel carousel) throws IOException {
        //获取上传路径  相对路径 files    获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/carousel/img");
        carousel.setImgPath("back/carousel/img/"+file.getOriginalFilename());
        carouselService.save(carousel);
        //上传
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        return null;
    }

}
