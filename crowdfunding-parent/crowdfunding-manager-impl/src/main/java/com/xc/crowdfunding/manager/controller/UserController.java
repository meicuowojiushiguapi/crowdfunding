package com.xc.crowdfunding.manager.controller;

import com.xc.crowdfunding.bean.Page;
import com.xc.crowdfunding.bean.User;
import com.xc.crowdfunding.manager.service.UserService;
import com.xc.crowdfunding.util.AjaxResult;
import com.xc.crowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/to_queryuser")
    public String to_queryuser(){
        return "user";
    }

    @ResponseBody
    @RequestMapping("/queryuser")
    public Object queryuser(Integer pageno,String querytext){
        AjaxResult result=new AjaxResult();
        try{
            Page page=new Page();
            HashMap<String,Object> map=new HashMap<>();
            map.put("pageno",pageno);
            map.put("pagesize",10);
            if(StringUtil.isNotEmpty(querytext)){
                map.put("querytext",querytext);
            }

            int startIndex=pageno-1>0?(pageno-1)*10:0;
            map.put("startIndex",startIndex);
            List<User> users = userService.queryUser(map);
            Integer queryUserCount = userService.queryUserCount();

            page.setTotalpages((int) Math.ceil(queryUserCount/10)+1);
            page.setTotalcount(queryUserCount);
            page.setDatas(users);

            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
        }

        return result;
    }
}
