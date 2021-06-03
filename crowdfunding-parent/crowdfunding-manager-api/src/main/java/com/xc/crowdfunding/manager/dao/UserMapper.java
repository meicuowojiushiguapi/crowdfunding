package com.xc.crowdfunding.manager.dao;

import com.xc.crowdfunding.bean.Page;
import com.xc.crowdfunding.bean.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserLogin(Map<String, Object> paramMap);

    List<User> queryUser(HashMap map);
    Integer queryUserCount();
}