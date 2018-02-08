package com.example.crane.controller;


import com.example.crane.dao.CraneTokenLogDao;
import com.example.crane.util.CheckInputUtils;
import com.example.crane.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类主要用来处理短信验证码的发送和验证
 * 因为引入了腾讯云的短信验证码第三方库
 */
@RestController
@RequestMapping("/crane/sms")
public class SmsController {

    @Autowired
    CraneTokenLogDao craneTokenLogDao;


    /**
     * 用户向某个手机号发送短信验证码
     * @param phone  传过来的手机号
     * @return   返回0表示短信验证码发送失败，返回1表示短信验证码发送成功
     */
    @RequestMapping("/getToken")
    public int getToken(@RequestParam(name = "phone",defaultValue = "0") String phone) {
        //首先检查手机号是否符合我们的要求
        if (!CheckInputUtils.checkTel(phone)) {
            //如果手机号不满足要求，则返回0
            return 0;
        }

        //首先生成一个由6位数字组成的随机字符串
        String code = StrUtil.getRandomCode();
        try {
            //TODO String result = SmsUtil.sendgetCode(phone, code, "5");
            craneTokenLogDao.saveNow(phone,code);
            return 1;   //验证码已经发送
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }





}
