package com.example.demo1.controller;

import com.example.demo1.services.UserVoTestService;
import com.example.demo1.vo.Restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserVoTestController {


    @Autowired
    private UserVoTestService userVoTestService;

    @GetMapping("/hello")
    public void hello(){
        userVoTestService.hello();
    }


    @GetMapping("/add")
    public void add(){
        userVoTestService.add();
    }

    @RequestMapping("/addUserSec")
    public void addUserSec(){
        userVoTestService.addUserSec();
    }

    /**
     *基哥的写法
     */
    @RequestMapping("/getUserOneToOne")
    public void getUserOneToOne(){
        userVoTestService.getOneToOne();
    }


    /**
     * 登录接口
     * @param username  前端传给我们的用户名
     * @param password  前端传给我们的密码
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Restful login(String username,String password){
        if(username==null||password==null){
            return Restful.fail();
        }
        List<Map<String,Object>> login = userVoTestService.login(username, password);
        if(login==null||login.size()==0){
            List<Map<String,Object>> failData=new ArrayList<>();
            Map<String,Object> map=new HashMap<>();
            map.put("id",1);
            map.put("username","admin");
            map.put("password","admin");
            map.put("role","role");
            failData.add(map);
            return Restful.messageFail("登录失败，用户不存在",failData);
        }
        return Restful.ok(login);
    }



}
