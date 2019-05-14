package com.example.hz.demo.Service;


import com.example.hz.demo.generated.user;
import com.example.hz.demo.generated.userExample;
import com.example.hz.demo.generated.userMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class UserService {
    @Autowired
    userMapper mapper;

    public user selectByPrimaryKey(int id){
        return mapper.selectByPrimaryKey(id);
    }

    @Cacheable(key="#name",cacheNames = "{user1,user2}")
    public PageInfo<user> selectByExample(String name){
        userExample ue = new userExample();
        PageHelper.startPage(1,1);
        String a = "%"+name+"%";
        ue.createCriteria().andNameLike(a);
        PageInfo<user> info = new PageInfo<>(mapper.selectByExample(ue));
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        return info;
    }




}
