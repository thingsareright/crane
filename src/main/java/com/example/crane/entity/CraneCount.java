package com.example.crane.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 对应Crane_Count表
 */
@Entity
@Table(name = "crane_picture_log")
public class CraneCount {

    private int picture_log_id;   //操作统计记录自增主键列
    private int picture_id; //对应图片表的主键，是个外键
    private Timestamp do_time;   //日期，对应照片的插入或删除日期
    private int way_do;  //操作图片的方式,TINYINT，0表示用户上传，1表示通过接口API传送的图片,2表示删除

    public CraneCount() {
    }

    public CraneCount( int picture_id, Timestamp do_time, int way_do) {
        this.picture_id = picture_id;
        this.do_time = do_time;
        this.way_do = way_do;
    }

    public CraneCount(int picture_log_id, int picture_id, Timestamp do_time, int way_do) {
        this.picture_log_id = picture_log_id;
        this.picture_id = picture_id;
        this.do_time = do_time;
        this.way_do = way_do;
    }

    @Id
    @GeneratedValue
    @Column(name = "count_id")
    public int getPicture_log_id() {
        return picture_log_id;
    }



    @Column(name = "picture_id")
    public int getPicture_id() {
        return picture_id;
    }

    @Column(name = "do_time")
    public Timestamp getDo_time() {
        return do_time;
    }

    @Column(name = "way_do")
    public int getWay_do() {
        return way_do;
    }

    public void setPicture_log_id(int picture_log_id) {
        this.picture_log_id = picture_log_id;
    }



    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public void setDo_time(Timestamp do_time) {
        this.do_time = do_time;
    }

    public void setWay_do(int way_do) {
        this.way_do = way_do;
    }
}
