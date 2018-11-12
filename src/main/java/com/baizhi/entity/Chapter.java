package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;//章节名称
    private String size;//章节大小
    private String duration ;//章节时长
    private String downLoadPath;//下载路径
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upLoadDate;//上传或修改日期
    private String album_id;//所属专辑
    public Chapter(){}
    public Chapter(String id, String title, String size, String duration, String downLoadPath, Date upLoadDate, String album_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downLoadPath = downLoadPath;
        this.upLoadDate = upLoadDate;
        this.album_id = album_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownLoadPath() {
        return downLoadPath;
    }

    public void setDownLoadPath(String downLoadPath) {
        this.downLoadPath = downLoadPath;
    }

    public Date getUpLoadDate() {
        return upLoadDate;
    }

    public void setUpLoadDate(Date upLoadDate) {
        this.upLoadDate = upLoadDate;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duratio='" + duration + '\'' +
                ", downLoadPath='" + downLoadPath + '\'' +
                ", upLoadDate=" + upLoadDate +
                ", album_id='" + album_id + '\'' +
                '}';
    }
}
