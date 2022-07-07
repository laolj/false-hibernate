package com.example.demo1.controller;

import com.example.demo1.pojo.UserVO;
import com.example.demo1.services.UserVoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserVoTestService userVoTestService;



    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Page<UserVO> test(){
        return userVoTestService.loadAll(0,2);
    }


    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<UserVO> getAll(){
        return userVoTestService.listAll();
    }





}
