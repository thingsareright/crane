package com.example.crane.controller;

import com.example.crane.dao.CranePictureDao;
import com.example.crane.dao.CraneUserDao;
import com.example.crane.entity.CranePicture;
import com.example.crane.entity.CraneUser;
import com.example.crane.model.UploadPictureModel;
import com.example.crane.util.CheckInputUtils;
import com.example.crane.util.ConstantUtil;
import com.example.crane.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

/**
 * 这个类用于处理上传和下载图片的请求
 */
@RestController
@RequestMapping("/crane/UploadDeletePicture")
public class UploadDeletePictureController {

    @Autowired
    CraneUserDao craneUserDao;
    @Autowired
    CranePictureDao cranePictureDao;

    public String UploadPicture(@RequestBody UploadPictureModel uploadPictureModel){

        if (uploadPictureModel.getUserPhone() == null || uploadPictureModel.getUserPassword() == null)
            return "-1";    //唉，连手机号和密码都是空的


        CraneUser craneUser = craneUserDao.findDistinctFirstByUserPhoneAndPassword(uploadPictureModel.getUserPhone(),
                uploadPictureModel.getUserPassword());
        if (craneUser == null | !CheckInputUtils.checkTel(uploadPictureModel.getUserPhone())){
            return "0"; //表示没有用户，该手机号还没有注册,或者密码错误
        }

        if (uploadPictureModel.getBase64() == null)
            return "1"; //表示上传的图片为空，上传失败

        UUID uuid = UUID.randomUUID();  //生成一个UUID作为文件名
        try {
            FileUtil.generateImage(uploadPictureModel.getBase64(),uuid.toString());
            return ConstantUtil.serverUrl + "/" + uuid.toString() + ".jpg"; //返回链接
        } catch (IOException e) {
            return "2"; //上传文件非空且上传失败
        }
    }

    //TODO 删除图片的业务逻辑还没有写呢 ！！！
}