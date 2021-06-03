package com.xc.crowdfunding.manager.service;

import com.xc.crowdfunding.bean.User;

import java.util.HashMap;

public interface UserService {
    User query_User_Login(HashMap<String, Object> map);
}
