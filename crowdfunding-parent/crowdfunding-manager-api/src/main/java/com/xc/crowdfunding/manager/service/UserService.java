package com.xc.crowdfunding.manager.service;

import com.xc.crowdfunding.bean.Page;
import com.xc.crowdfunding.bean.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    User query_User_Login(HashMap<String, Object> map);

    List<User> queryUser(HashMap map);
    public Integer queryUserCount();
}
