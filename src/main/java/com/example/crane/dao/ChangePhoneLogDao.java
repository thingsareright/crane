package com.example.crane.dao;

import com.example.crane.entity.ChangePhoneLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 这个类用于建立对chang_phone_log表的映射
 */
public interface ChangePhoneLogDao extends JpaRepository<ChangePhoneLog,Long>{
}
