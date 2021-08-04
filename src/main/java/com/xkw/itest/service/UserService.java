package com.xkw.itest.service;

import com.xkw.itest.bean.UserBean;
import com.xkw.itest.utils.ResultMsg;

/**
 * @author : chenghao
 * create at:  2021/3/26  2:10 下午
 * @description:
 */
public interface UserService {
    UserBean loginIn(String name,String password);

    ResultMsg<String> insert(UserBean bean);

    ResultMsg<String> updateUserByPhone(UserBean bean);

    ResultMsg<String> deleteByPhone(String phone);
}
