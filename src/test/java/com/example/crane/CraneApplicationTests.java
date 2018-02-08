package com.example.crane;

import com.example.crane.dao.*;
import com.example.crane.entity.CranePicture;
import com.example.crane.entity.CraneUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * 专用测试类，对各种数据接口进行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CraneApplicationTests {

	@Autowired
	CraneUserDao craneUserDao;
	@Autowired
	CraneCountDao craneCountDao;
	@Autowired
	ChangePhoneLogDao changePhoneLogDao;
	@Autowired
	CranePictureDao cranePictureDao;
	@Autowired
    CraneTokenLogDao craneTokenLogDao;

	@Test
	public void contextLoads() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		CraneUser craneUser = new CraneUser(1,"18838951998","12345678909876543210789456212301",timestamp
		,timestamp1,"2271366490@qq.com",1,2);

		CranePicture cranePicture = new CranePicture(1,"jdks");

		craneUserDao.save(craneUser);
		cranePictureDao.save(cranePicture);

		craneUser.setUserPhone("18838951997");
		craneUserDao.save(craneUser);
		craneUser.setUserPhone("18838951997");
		craneUserDao.save(craneUser);

		cranePictureDao.delete(cranePicture);
	}

}
