package com.xkw.itest;

import com.xkw.itest.bean.UserBean;
import com.xkw.itest.service.UserService;

import com.xkw.itest.utils.ResultMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItestApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		UserBean userBean = userService.loginIn("a","a");
		if (userBean != null) {
			System.out.println("该用户ID为：");
			System.out.println(userBean.getId());
		} else {
			System.out.println("该用户不存在");
		}
	}

	@Test
	public void insertUser() throws Exception {
		UserBean userBean = new UserBean();
		userBean.setName("程浩");
		userBean.setPassword("123abc");
		userBean.setAddress("湖北武汉");
		userBean.setNickName("小名");
		userBean.setPhone("15071795992");
		ResultMsg<String> resultMsg = userService.insert(userBean);
		if (resultMsg.getCode() == 0) {
			System.out.println("注册成功");
		} else {
			System.out.println(resultMsg.getMsg());
		}
	}

	@Test
	public void updateUser() {
		UserBean userBean = new UserBean();
		userBean.setNickName("小名2");
		userBean.setPassword("sxckjl");
		userBean.setName("程浩2");
		userBean.setAddress("新地址");
		userBean.setPhone("15071795992");
		ResultMsg<String> resultMsg = userService.updateUserByPhone(userBean);
		if (resultMsg.getCode() == 0) {
			System.out.println("修改成功");
		} else {
			System.out.println(resultMsg.getMsg());
		}
	}

	@Test
	public void deleteByPhone() {
		ResultMsg<String> resultMsg = userService.deleteByPhone("15071795991");
		if (resultMsg.getCode() == 0) {
			System.out.println("删除成功");
		} else {
			System.out.println(resultMsg.getMsg());
		}
	}

	@Test
	public void redisTest() {
		//连接本地的Redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");

		//查看服务是否运行
		System.out.println("服务正在运行："+jedis.ping());
	}

}
