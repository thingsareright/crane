package com.example.crane.dao;

import com.example.crane.entity.CranePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 这个类用来实现CranePicture的数据接口
 */
public interface CranePictureDao extends JpaRepository<CranePicture,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO crane_picture(user_id, picture_url) VALUES (?1, ?2)", nativeQuery = true)
    public void insertAfterUpload(int user_id, String picture_url);

}
