package com.example.crane.dao;

import com.example.crane.entity.CraneTokenLog;
import com.example.crane.entity.CraneUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;

/**
 * 这个接口包含了对token_log表的各种操作
 */
public interface CraneTokenLogDao extends JpaRepository<CraneTokenLog, Long>{

    @Modifying
    @Transactional
    @Query( value = "INSERT INTO crane_token_log(token_phone, token, log_time, ok_flag) VALUES " +
            "(?1,?2, NOW(),1)" , nativeQuery = true)
    public void saveNow(String userPhone, String code);

    @Query(value = "select log_time from crane_token_log where token_phone = ?1 and token = ?2  order by log_time  desc limit 1", nativeQuery = true)
    public Timestamp findTime(String phone, String token);
}
