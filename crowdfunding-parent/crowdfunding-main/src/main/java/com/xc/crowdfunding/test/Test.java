package com.xc.crowdfunding.test;

import com.xc.crowdfunding.bean.User;
import com.xc.crowdfunding.manager.dao.UserMapper;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        UserMapper userMapper = (UserMapper) classPathXmlApplicationContext.getBean("userMapper");
        for(int i=2;i<100;i++){
            User user=new User();
            user.setId(i+1);
            user.setLoginacct("testacct"+i);
            user.setUsername("testname"+i);
            user.setUserpswd("passwd"+i);
            user.setCreatetime("2021-06-03 18:10:34");
            user.setEmail("testemil"+i);
            userMapper.insert(user);
        }
    }
}
