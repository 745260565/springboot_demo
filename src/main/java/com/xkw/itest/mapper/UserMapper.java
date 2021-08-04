package com.xkw.itest.mapper;

import com.xkw.itest.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : chenghao
 * create at:  2021/3/26  2:10 下午
 * @description:
 */

@Repository
public interface UserMapper {

    UserBean getInfo(@Param("name") String name,@Param("password") String password);

    UserBean getUserByPhone(@Param("phone") String phone);

    int insert(UserBean userBean);

    int updateByUserPhone(UserBean userBean);

    int deleteByPhone(@Param("phone") String phone);
}

