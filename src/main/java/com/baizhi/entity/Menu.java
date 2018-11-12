package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;
    private String title;//菜单名称
    private String iconCls;//菜单名称
    private String href;//菜单对应的详细页面路径
    private String parentld;//所属一级分类菜单id;
    private List<Menu> lists;
    public Menu(){}
    public Menu(String id, String title, String iconCls, String href, String parentld, List<Menu> lists) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.href = href;
        this.parentld = parentld;
        this.lists = lists;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParentld() {
        return parentld;
    }

    public void setParentld(String parentld) {
        this.parentld = parentld;
    }

    public List<Menu> getLists() {
        return lists;
    }

    public void setLists(List<Menu> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parentld='" + parentld + '\'' +
                ", lists=" + lists +
                '}';
    }
}
