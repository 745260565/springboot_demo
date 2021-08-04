package com.xkw.itest.serviceImpl;

import com.xkw.itest.bean.UserBean;
import com.xkw.itest.mapper.UserMapper;
import com.xkw.itest.service.UserService;
import com.xkw.itest.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : chenghao
 * create at:  2021/3/26  2:10 下午
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public ResultMsg<String> insert(UserBean bean) {
        if (verifyBean(bean).getCode() != 0) {
            return verifyBean(bean);
        }
        bean.setCreateTime(LocalDateTime.now());
        try {
            userMapper.insert(bean);
            return ResultMsg.success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error("注册失败");
        }
    }

    @Override
    public ResultMsg<String> updateUserByPhone(UserBean bean) {
        if (bean.getPhone() == null) {
            return ResultMsg.error("手机号不能为空");
        }
        try {
            userMapper.updateByUserPhone(bean);
            return ResultMsg.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error("修改成功");
        }
    }

    @Override
    public ResultMsg<String> deleteByPhone(String phone) {
        if (phone == null) {
            return ResultMsg.error("手机号不能为空");
        }
        try {
            userMapper.deleteByPhone(phone);
            return ResultMsg.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error("删除失败");
        }
    }

    private ResultMsg<String> verifyBean(UserBean bean) {
        if (bean.getPhone() == null) {
            return ResultMsg.error("手机号不能为空");
        }
        UserBean userBean = userMapper.getUserByPhone(bean.getPhone());
        if (userBean != null) {
            return ResultMsg.error("该用户已经存在");
        }
        if (bean.getPhone().length() != 11) {
            return ResultMsg.error("手机号长度不对");
        }
        return ResultMsg.success(null);
    }
}

