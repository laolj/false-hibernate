package com.example.demo1.controller;

import com.example.demo1.services.UserVoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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



}
