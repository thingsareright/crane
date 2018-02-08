package com.example.crane.dao;

import com.example.crane.entity.CranePicture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 这个类用来实现CranePicture的数据接口
 */
public interface CranePictureDao extends JpaRepository<CranePicture,Long> {
}
