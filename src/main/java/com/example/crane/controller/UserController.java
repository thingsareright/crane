package com.example.crane.controller;

import com.example.crane.dao.CraneUserDao;
import com.example.crane.dao.CraneTokenLogDao;
import com.example.crane.model.UserRegisterForgetPasswordModel;
import com.example.crane.util.CheckInputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

import static org.apache.tomcat.jni.Time.now;

/**
 * 这个类用于处理关于登录，注册，忘记密码的信息
 */
@RestController
@RequestMapping("/crane/user")
public class UserController {

    @Autowired
    CraneUserDao craneUserDao;

    @Autowired
    CraneTokenLogDao craneTokenLogDao;


    @RequestMapping("/register")
    public int register(@RequestBody UserRegisterForgetPasswordModel model) {
        String phone = model.getUserPhone();
        String password = model.getUserPassword();
        String token = model.getTokenCode();

        if (!CheckInputUtils.checkTel(phone) | password == null | token == null)
            return 0;   //信息不全

        Timestamp timestamp = craneTokenLogDao.findTime(phone, token);

        if (timestamp == null)
            return 2; //没有记录

        if ((System.currentTimeMillis() - timestamp.getTime() )/(1800000) <= 1 ){
            craneUserDao.registerPhonePassword(phone,password);
            return 1;   //注册成功
        }

        return 3;   //表示注册失败
    }

}
