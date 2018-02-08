package com.example.crane.dao;

import com.example.crane.entity.CraneUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 这个类用来实现CraneUser类的数据接口
 */
public interface CraneUserDao extends JpaRepository<CraneUser, Long> {

    public CraneUser findDistinctFirstByUserPhoneAndPassword(String userPhone, String userPassword);

    @Modifying
    @Transactional
    @Query(value = "insert into crane_user(user_phone, user_password, register_time, last_login_time, user_kind, state_flag) VALUES (?1, ?2, now(), now(), 0, 0)", nativeQuery = true)
    /**
     * 注意，在这里我们规定注册后用户可以立即上传图片
     */
    public void registerPhonePassword(String userPhone, String userPassword);
}
