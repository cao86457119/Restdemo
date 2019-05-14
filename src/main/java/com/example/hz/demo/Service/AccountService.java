package com.example.hz.demo.Service;


import com.example.hz.demo.generated.*;
import com.example.hz.demo.logUtil.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    accountMapper mapper;

    public account selectByPrimaryKey(int id){
        return mapper.selectByPrimaryKey(id);
    }

    @Log(after = "123",before = "#name")
    public PageInfo<account> selectByExample(String name){
        accountExample ue = new accountExample();
        PageHelper.startPage(1,1);
        String a = "%"+name+"%";
        ue.createCriteria().andNameLike(a);
        PageInfo<account> info = new PageInfo<>(mapper.selectByExample(ue));
        return info;
    }




}
