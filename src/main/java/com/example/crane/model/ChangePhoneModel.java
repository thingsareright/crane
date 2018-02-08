package com.example.crane.model;

/**
 * 用户更换手机号时需要上传的JSON数据包
 */
public class ChangePhoneModel {

    private String oldPhone;
    private String newPhone;
    private String tokenCode;
    private String password;

    public ChangePhoneModel() {
    }

    public ChangePhoneModel(String oldPhone, String newPhone, String tokenCode, String password) {
        this.oldPhone = oldPhone;
        this.newPhone = newPhone;
        this.tokenCode = tokenCode;
        this.password = password;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
