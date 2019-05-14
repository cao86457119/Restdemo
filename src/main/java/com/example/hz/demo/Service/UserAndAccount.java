package com.example.hz.demo.Service;

import com.example.hz.demo.entity.UserEntity;
import com.example.hz.demo.generated.UserAndAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAndAccount {

    @Autowired
    UserAndAccountMapper mapper;


    public List<UserEntity> selectUserWithAccountById(int id){
       return mapper.selectUserWithAccountById(id);
    }
}
