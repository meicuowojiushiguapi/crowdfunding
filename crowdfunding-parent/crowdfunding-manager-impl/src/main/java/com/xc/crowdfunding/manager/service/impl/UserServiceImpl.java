package com.xc.crowdfunding.manager.service.impl;

import com.xc.crowdfunding.bean.User;
import com.xc.crowdfunding.manager.dao.UserMapper;
import com.xc.crowdfunding.manager.service.UserService;
import com.xc.crowdfunding.exception.LoginFailException;
import com.xc.crowdfunding.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User query_User_Login(HashMap<String, Object> map) {
        User user = userMapper.queryUserLogin(map);
        if(user==null){

            throw new LoginFailException("用户名或密码错误");
        }
        return user;
    }
}
