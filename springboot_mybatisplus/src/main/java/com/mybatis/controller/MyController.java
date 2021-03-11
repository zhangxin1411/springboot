package com.mybatis.controller;

import com.mybatis.pojo.User;
import com.mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatis")
public class MyController {


    @Autowired
    MyService myService;
    @RequestMapping("test1")
    public User test1(){
      return  myService.findUserById("1");
    }

    @RequestMapping("tran1")
    public String transactional(){
        myService.transactional();
        return "ok";
    }

}
