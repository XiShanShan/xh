package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
   private AlbumService albumService;
    @RequestMapping("/findAll")

    public @ResponseBody
    Map<String, Object> findAll(Integer page, Integer rows) {

         System.out.println("-------------------------");
        System.out.println("page:"+page);
        System.out.println("rows:"+rows);

        Map<String, Object> results = new HashMap<String, Object>();
        //当前页数据rows:
        List<Album> albums = albumService.findByPage(page, rows);

        //总记录数
        Long totals = albumService.findTotals();
         System.out.println("totals"+totals);
        results.put("total", totals);
        results.put("rows", albums);
        return results;
    }

    @RequestMapping("/saveAlbum")
    @ResponseBody
    public String save(MultipartFile file, HttpServletRequest request, Album album) throws IOException {
        //获取上传路径  相对路径 files    获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/img");
        album.setCoverImg("back/album/img/"+file.getOriginalFilename());
        System.out.println("++++++++"+file);
        albumService.save(album);
        //上传
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        return null;
    }

}
