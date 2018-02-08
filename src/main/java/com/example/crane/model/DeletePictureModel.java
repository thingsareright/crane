package com.example.crane.model;

/**
 * 这个类表示删除图片时的JSON数据包
 */
public class DeletePictureModel {

    private String userPhone;
    private String pictureUrl;
    private String userPassword;    //这里的密码都是加密过的，跟用户在前端输入的不一致，但是与数据库中存储的已加密密码一致‘


    public DeletePictureModel() {
    }

    public DeletePictureModel(String userPhone, String pictureUrl, String userPassword) {
        this.userPhone = userPhone;
        this.pictureUrl = pictureUrl;
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
