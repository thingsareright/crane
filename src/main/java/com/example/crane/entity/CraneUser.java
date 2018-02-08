package com.example.crane.entity;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * 这个类，映射的是数据库里的用户表
 */

@Entity
@Table(name = "crane_user")
public class CraneUser {

    private int userId; //用户自增主键列
    private String userPhone;   //用户手机号码，是用户的一个唯一标志
    private String password;    //用户密码，MDK5存放
    private Timestamp registerTime; //注册时间
    private Timestamp lastLoginTime;    //上次登录的时间
    private String emailAddress;    //邮箱地址
    private int userKind;   //用户类别，tinyint，0表示普通用户，1表示银牌会员，2表示金牌会员，3表示钻石会员
    private int stateFlag; //黑名单状态标志，tinyint，为1表示用户上传图片数量达到当天上传图片的上限10，为2表示用户被永久封号，为0表示用户可以上传图片

    public CraneUser() {
    }

    public CraneUser(String userPhone, String password, Timestamp registerTime, Timestamp lastLoginTime, String emailAddress, int userKind, int stateFlag) {
        this.userPhone = userPhone;
        this.password = password;
        this.registerTime = registerTime;
        this.lastLoginTime = lastLoginTime;
        this.emailAddress = emailAddress;
        this.userKind = userKind;
        this.stateFlag = stateFlag;
    }

    public CraneUser(int userId, String userPhone, String password, Timestamp registerTime, Timestamp lastLoginTime, String emailAddress, int userKind, int stateFlag) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.password = password;
        this.registerTime = registerTime;
        this.lastLoginTime = lastLoginTime;
        this.emailAddress = emailAddress;
        this.userKind = userKind;
        this.stateFlag = stateFlag;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    @Column(name = "register_time")
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @Column(name = "user_kind")
    public int getUserKind() {
        return userKind;
    }

    @Column(name = "state_flag")
    public int getStateFlag() {
        return stateFlag;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserKind(int userKind) {
        this.userKind = userKind;
    }

    public void setStateFlag(int stateFlag) {
        this.stateFlag = stateFlag;
    }
}
