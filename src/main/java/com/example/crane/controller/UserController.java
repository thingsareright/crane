package com.example.crane.controller;

import com.example.crane.dao.CraneUserDao;
import com.example.crane.dao.CraneTokenLogDao;
import com.example.crane.entity.CraneUser;
import com.example.crane.model.UserChangePasswordModel;
import com.example.crane.model.UserRegisterForgetPasswordModel;
import com.example.crane.util.CheckInputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

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

        if (!CheckInputUtils.checkTel(phone) | !CheckInputUtils.checkDatabasePassword(password) | token == null)
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

    @RequestMapping("/forgetPassword")
    public int forgetPassword(@RequestBody UserRegisterForgetPasswordModel model){
        String phone = model.getUserPhone();
        String password = model.getUserPassword();
        String token = model.getTokenCode();

        if (!CheckInputUtils.checkTel(phone) | !CheckInputUtils.checkDatabasePassword(password) | token == null)
            return 0;   //信息不全

        Timestamp timestamp = craneTokenLogDao.findTime(phone, token);

        if (timestamp == null)
            return 2; //没有记录

        if ((System.currentTimeMillis() - timestamp.getTime() )/(1800000) <= 1 ){
            if (craneUserDao.findTopByUserPhone(phone) == null)
                return 4;   //表示改手机号还未注册
            craneUserDao.forgetPasswordUpdate(phone,password);
            return 1;   //修改密码成功
        }

        return 3;   //表示修改密码失败,基本原因应该是因为超时
    }

    /**
     * 这个方法用来处理在已知密码的情况下更改密码的请求
     * @param model
     * @return
     */
    @RequestMapping("/resetPassword")
    public int resetPassword(@RequestBody UserChangePasswordModel model) {
        String phone = model.getUserPhone();
        String oldPassword = model.getOldPassword();
        String newPassword = model.getNewPassword();

        if (!CheckInputUtils.checkTel(phone) | !CheckInputUtils.checkDatabasePassword(oldPassword)  |
                !CheckInputUtils.checkDatabasePassword(newPassword))
            return 0;   //信息不全

        List<CraneUser> craneUsers = craneUserDao.findByUserPhoneAndPassword(phone, oldPassword);
        if (craneUsers == null)
            return 2;   //没有这样的用户
        if (craneUsers.size() != 1)
            return 3;   //有一定的SQL注入风险
        craneUsers.get(0).setPassword(newPassword);
        craneUserDao.save(craneUsers.get(0));
        return 1;
    }

}
