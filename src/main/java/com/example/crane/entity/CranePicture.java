package com.example.crane.entity;

import javax.persistence.*;

/**
 * 这个类用来映射crane_picture表
 */
@Entity
@Table(name = "crane_picture")
public class CranePicture {
    private int picture_id; //自增主键列
    private int user_id;    //用于作为外键映射到crane_user表的user_id列
    private String url;        //图片的URL，其实只是相应目录下的图片文件名（不带后缀）罢了,因为是UUID，所以只有四十个字符

    public CranePicture() {
    }

    public CranePicture(int picture_id, int user_id, String url) {
        this.picture_id = picture_id;
        this.user_id = user_id;
        this.url = url;
    }

    public CranePicture(int user_id, String url) {
        this.user_id = user_id;
        this.url = url;
    }

    @Id
    @GeneratedValue
    @Column(name = "picture_id")
    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Column(name = "picture_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
