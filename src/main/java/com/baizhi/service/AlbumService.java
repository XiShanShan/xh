package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findByPage(Integer page, Integer rows);

    Long findTotals();

    //添加
    void save(Album album);


}
