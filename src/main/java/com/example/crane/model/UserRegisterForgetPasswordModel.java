package com.example.crane.model;

/**
 * 用户注册和忘记密码时需要上传的JSON数据包
 */
public class UserRegisterForgetPasswordModel {

    private String userPhone;
    private String userPassword;
    private String tokenCode;   //短信验证码

    public UserRegisterForgetPasswordModel() {
    }

    public UserRegisterForgetPasswordModel(String userPhone, String userPassword, String tokenCode) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.tokenCode = tokenCode;
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

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }
}
