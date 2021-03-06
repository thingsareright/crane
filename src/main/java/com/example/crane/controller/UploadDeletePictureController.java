package com.example.crane.controller;

import com.example.crane.dao.CranePictureDao;
import com.example.crane.dao.CraneUserDao;
import com.example.crane.entity.CranePicture;
import com.example.crane.entity.CraneUser;
import com.example.crane.model.DeletePictureModel;
import com.example.crane.model.UploadPictureModel;
import com.example.crane.util.CheckInputUtils;
import com.example.crane.util.ConstantUtil;
import com.example.crane.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
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

    @RequestMapping("/uploadPicture")
    public String UploadPicture(@RequestBody UploadPictureModel uploadPictureModel){

        if (uploadPictureModel.getUserPhone() == null || uploadPictureModel.getUserPassword() == null)
            return "-1";    //唉，连手机号和密码都是空的

        if ( !CheckInputUtils.checkTel(uploadPictureModel.getUserPhone())){
            return "0"; //手机号有问题
        }

        List<CraneUser> craneUserList = craneUserDao.findByUserPhoneAndPassword(uploadPictureModel.getUserPhone(),
                uploadPictureModel.getUserPassword());
        if (craneUserList == null)
            return "2"; //不好意思，没有那个用户或者密码错误
        if (craneUserList.size() > 1)
            return "3"; //兄弟，有可能有SQL注入啊


        if (uploadPictureModel.getBase64() == null)
            return "4"; //表示上传的图片为空，上传失败

        UUID uuid = UUID.randomUUID();  //生成一个UUID作为文件名
        try {
            String uploadFilePath = new String(uuid.toString());
            FileUtil.generateImage(uploadPictureModel.getBase64(),uploadFilePath);
            cranePictureDao.insertAfterUpload(craneUserList.get(0).getUserId(), uploadFilePath);
            return ConstantUtil.serverUrl + "/" + uploadFilePath + ".jpg"; //返回链接
        } catch (IOException e) {
            return "5"; //上传文件非空且上传失败
        }
    }


    /**
     * 用户删除一个图片，一个指定路径的图片
     * @param model 删除图片时需要用到的POST格式请求包的格式规范
     * @return  成功则返回1，否则返回0
     */
    @RequestMapping("/deletePicture")
    public int DeletePicture(@RequestBody DeletePictureModel model) {


            try {
                String userPhone = model.getUserPhone();
                String userPassword = model.getUserPassword();
                String pictureUrl = model.getPictureUrl();

                if (userPhone == null | userPassword == null | pictureUrl == null)
                    return 0;   //因为信息不全所以操作失败

                if (!CheckInputUtils.checkTel(userPhone))
                    return 3;   //号码不符合规范所以操作失败

                //不管有没有这个文件，执行了这个方法后就不会有这样的文件存在
                FileUtil.judeFileExistsAndDelete(pictureUrl);


                cranePictureDao.DeleteAfterQuery(userPhone, userPassword,pictureUrl);

                return 1;
            } catch (Exception e){
                return 0;
            }

    }
}
