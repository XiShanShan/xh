package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String title;//专辑名称
    private String coverImg;//专辑图片
    private Integer count;//专辑集数
    private String author;//作者
    private String broadCaet;//播音
    private String content;//内容简介
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;//发布日期
    private List<Chapter>children;

    public Album(){}

    public Album(String id, String title, String coverImg, Integer count, String author, String broadCaet, String content, Date releaseDate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.count = count;
        this.author = author;
        this.broadCaet = broadCaet;
        this.content = content;
        this.releaseDate = releaseDate;
        this.children = children;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCaet() {
        return broadCaet;
    }

    public void setBroadCaet(String broadCaet) {
        this.broadCaet = broadCaet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", author='" + author + '\'' +
                ", broadCaet='" + broadCaet + '\'' +
                ", content='" + content + '\'' +
                ", releaseDate=" + releaseDate +
                ", children=" + children +
                '}';
    }
}
