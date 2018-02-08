package com.example.crane.model;

/**
 * 用户记得密码更改的情况下需要的请求的数据包
 */
public class UserChangePasswordModel {

    private String userPhone;
    private String oldPassword;
    private String newPassword;

    public UserChangePasswordModel() {
    }

    public UserChangePasswordModel(String userPhone, String oldPassword, String newPassword) {
        this.userPhone = userPhone;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
