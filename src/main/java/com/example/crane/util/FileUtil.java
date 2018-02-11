package com.example.crane.util;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件操作工具类
 */
public class FileUtil {

    //本项目图片文件存放路径 TODO 以后要改成静态资源服务器的路径
    private static String imgpath = "/home/meng/IdeaProjects/crane/src/main/java/com/example/crane/picture/";

    public static boolean generateImage(String base64, String filename) throws IOException {
        if (base64 == null)
            return false;
        //解密
        byte[] b = Base64.decodeBase64(base64);
        //处理数据
        // 处理数据
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }

        //找以前是否有同名文件
        File file = new File( imgpath + filename + ".jpg");
        OutputStream stream = new FileOutputStream(file);
        stream.write(b);
        stream.flush();
        stream.close();
        return true;
    }

    // 判断文件是否存在,存在则删除，并重新创建
     public static void judeFileExists(File file) throws IOException {
        if (file.exists()) {
            file.delete();

        }
        file.createNewFile();
     }



    /**
     * 判断文件是否存在，存在则删除,操作后不存在文件即返回1，否则返回0
     * @param filename 所以这里的参数只要是数据库中的名字就行了，不用带后缀名
     * @return 成功删除则返回1，否则返回0
     */
    public static int judeFileExistsAndDelete(String filename) {
        File file = new File( imgpath + filename + ".jpg"); //所以这里的参数只要是数据库中的名字就行了，不用带后缀名
        try {
            if (file.exists()) {
                file.delete();

            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
