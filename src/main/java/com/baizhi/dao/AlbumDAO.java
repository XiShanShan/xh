package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO {
    //添加专辑
    void save(Album album);

    List<Album> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long findTotals();

}
