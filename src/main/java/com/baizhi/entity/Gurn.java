package com.baizhi.entity;

public class Gurn {
    private String id;
    private String name;
    private String headPortrait;//头像
    private String gender;//性别
    public Gurn(){}
    public Gurn(String id, String name, String headPortrait, String gender) {
        this.id = id;
        this.name = name;
        this.headPortrait = headPortrait;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gurn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}



