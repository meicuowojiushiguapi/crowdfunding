package com.xc.crowdfunding.controller;

import com.xc.crowdfunding.bean.User;
import com.xc.crowdfunding.manager.service.UserService;
import com.xc.crowdfunding.util.AjaxResult;
import com.xc.crowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class DispatcherServlet {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }
    @RequestMapping("/main")
    public  String main(){
        return "main";
    }
    @RequestMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
    @ResponseBody
    @RequestMapping("/do_login")
    public AjaxResult do_login(String loginacct, String userpswd,String  type, HttpSession session){
        AjaxResult result=new AjaxResult();

        try{
            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("loginacct",loginacct);
            map.put("userpswd", MD5Util.digest(userpswd));
            map.put("type",type);
            User user = userService.query_User_Login(map);
            result.setSuccess(true);
            session.setAttribute("user",user);
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("账号密码错误！");
        }

        return result;

    }
}
