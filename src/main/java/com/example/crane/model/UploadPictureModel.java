package com.example.crane.model;

/**
 * 这个类用于表示上传图片时要传送的JSON数据包
 */
public class UploadPictureModel {

    private String userPhone;
    private String userPassword;
    private String base64;  //图片的base64编码

    public UploadPictureModel() {
    }

    public UploadPictureModel(String userPhone, String userPassword, String base64) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.base64 = base64;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
