package com.example.crane.dao;

import com.example.crane.entity.CranePicture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 这个接口用于对crane_count表中的数字进行操作
 */
public interface CraneCountDao extends JpaRepository<CranePicture,Long> {
}
