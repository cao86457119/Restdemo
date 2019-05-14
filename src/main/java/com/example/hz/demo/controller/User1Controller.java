package com.example.hz.demo.controller;

import com.example.hz.demo.Service.AccountService;
import com.example.hz.demo.Service.UserService;
import com.example.hz.demo.generated.account;
import com.example.hz.demo.generated.user;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User1Controller {
    @Autowired
    UserService UserService;

    @Autowired
    AccountService accountService;

    @RequestMapping("/user1/{id}")
    public user getUser(@PathVariable("id")int  id){
        return UserService.selectByPrimaryKey(id);

    }

    @RequestMapping("/user1/name/{name}")
    public PageInfo<user> getUser(@PathVariable("name")String  name){
        return UserService.selectByExample(name);

    }
    @RequestMapping("/account1/{id}")
    public account getAccount(@PathVariable("id")int  id){
        return accountService.selectByPrimaryKey(id);

    }

    @RequestMapping("/account1/name/{name}")
    public PageInfo<account> getAccount(@PathVariable("name")String  name){
        return accountService.selectByExample(name);

    }
}
