package com.example.crane.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 这个表用于验证码的记录
 */
@Entity
@Table(name = "crane_token_log")
public class CraneTokenLog {

    private int token_log_id;  //记录表自增主键列
    private String token_phone; //需要验证码的手机号
    private String token;   //验证码
    private Timestamp log_time; //验证码生成的时间
    private int ok_flag;    //验证码是否发送成功，成功则为1，失败为0

    public CraneTokenLog() {
    }

    public CraneTokenLog(String token_phone, String token) {
        this.token_phone = token_phone;
        this.token = token;
    }

    public CraneTokenLog(String token_phone, String token, Timestamp log_time, int ok_flag) {
        this.token_phone = token_phone;
        this.token = token;
        this.log_time = log_time;
        this.ok_flag = ok_flag;
    }

    public CraneTokenLog(int token_log_id, String token_phone, String token, Timestamp log_time, int ok_flag) {
        this.token_log_id = token_log_id;
        this.token_phone = token_phone;
        this.token = token;
        this.log_time = log_time;
        this.ok_flag = ok_flag;
    }

    @Id
    @GeneratedValue
    @Column(name = "token_log_id")
    public int getToken_log_id() {
        return token_log_id;
    }

    @Column(name = "token_phone")
    public String getToken_phone() {
        return token_phone;
    }

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    @Column(name = "log_time")
    public Timestamp getLog_time() {
        return log_time;
    }

    @Column(name = "ok_flag")
    public int getOk_flag() {
        return ok_flag;
    }

    public void setToken_log_id(int token_log_id) {
        this.token_log_id = token_log_id;
    }

    public void setToken_phone(String token_phone) {
        this.token_phone = token_phone;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLog_time(Timestamp log_time) {
        this.log_time = log_time;
    }

    public void setOk_flag(int ok_flag) {
        this.ok_flag = ok_flag;
    }
}
