package com.example.crane.entity;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 映射change_phone_log表，记录关于用户手机号的变更
 */
@Entity
@Table(name = "change_phone_log")
public class ChangePhoneLog {

    private int change_log_id;  //日志记录自增主键列
    private String old_phone;   //原来的手机号
    private String new_phone;   //现在的手机号
    private Timestamp change_time;  //更改手机号的时间
    private int ok_flag;    //成功更改为1，否则为0

    public ChangePhoneLog() {
    }

    public ChangePhoneLog(String old_phone, String new_phone, Timestamp change_time, int ok_flag) {
        this.old_phone = old_phone;
        this.new_phone = new_phone;
        this.change_time = change_time;
        this.ok_flag = ok_flag;
    }

    public ChangePhoneLog(int change_log_id, String old_phone, String new_phone, Timestamp change_time, int ok_flag) {
        this.change_log_id = change_log_id;
        this.old_phone = old_phone;
        this.new_phone = new_phone;
        this.change_time = change_time;
        this.ok_flag = ok_flag;
    }

    @Id
    @GeneratedValue
    @Column(name = "change_log_id")
    public int getChange_log_id() {
        return change_log_id;
    }

    public void setChange_log_id(int change_log_id) {
        this.change_log_id = change_log_id;
    }

    @Column(name = "old_phone")
    public String getOld_phone() {
        return old_phone;
    }

    public void setOld_phone(String old_phone) {
        this.old_phone = old_phone;
    }

    @Column(name = "new_phone")
    public String getNew_phone() {
        return new_phone;
    }

    public void setNew_phone(String new_phone) {
        this.new_phone = new_phone;
    }

    @Column(name = "change_time")
    public Timestamp getChange_time() {
        return change_time;
    }

    public void setChange_time(Timestamp change_time) {
        this.change_time = change_time;
    }

    @Column(name = "ok_flag")
    public int getOk_flag() {
        return ok_flag;
    }

    public void setOk_flag(int ok_flag) {
        this.ok_flag = ok_flag;
    }
}
