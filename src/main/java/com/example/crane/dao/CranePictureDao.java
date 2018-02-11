package com.example.crane.dao;

import com.example.crane.entity.CranePicture;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 这个类用来实现CranePicture的数据接口
 */
public interface CranePictureDao extends JpaRepository<CranePicture,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO crane_picture(user_id, picture_url) VALUES (?1, ?2)", nativeQuery = true)
    public void insertAfterUpload(int user_id, String picture_url);

    /**
     * 这个方法一直报错 TODO
     * @param userPhone
     * @param userPassword
     * @param pictureUrl
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM crane_picture WHERE user_id IN (SELECT DISTINCT user_id FROM crane_user WHERE ?1 = user_phone AND ?2 = user_password) AND picture_url = ?3" , nativeQuery = true)
    public void DeleteAfterQuery(String userPhone, String userPassword, String pictureUrl);

    public void deleteAllByUrl(String url);

}
