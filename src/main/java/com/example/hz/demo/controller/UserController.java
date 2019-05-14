package com.example.hz.demo.controller;

import com.example.hz.demo.LocksUtil.Lock;
import com.example.hz.demo.Service.UserAndAccount;
import com.example.hz.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserAndAccount userAndAccount;

    @RequestMapping("/ids/{id}")
    public List<UserEntity> userEntityList(@PathVariable("id") int id){
        return userAndAccount.selectUserWithAccountById(id);
    }


//    //请求例子：http://localhost:9001/getUserWithCompany/1
//    /**请求结果：{"id":1,"name":"aa","company":{"id":1,"companyName":"xx公司"},"accounts":null}*/
//    @RequestMapping("/getUserWithCompany/{id}")
//    public UserEntity getUserWithCompany(@PathVariable("id") Long id) {
//        UserEntity user = userMapper.getUserWithCompany(id);
//        return user;
//    }
//
//
//    //请求例子：http://localhost:9001/getUserWithAccount/1
//    /**请求结果：{"id":1,"name":"aa","company":null,"accounts":[{"id":1,"accountName":"中行"},{"id":2,"accountName":"工行"}]}*/
//    @RequestMapping("/getUserWithAccount/{id}")
//    public UserEntity getUserWithAccount(@PathVariable("id") Long id) {
//        UserEntity user = userMapper.getUserWithAccount(id);
//        return user;
//    }
//
//
//    /**请求例子：http://localhost:9001/getUserWithAccount/1*/
//    /**请求结果：[{"id":1,"name":"aa","company":{"id":1,"companyName":"xx公司"},"accounts":[{"id":1,"accountName":"中行"},
//       {"id":2,"accountName":"工行"}]},{"id":2,"name":"bb","company":{"id":2,"companyName":"yy公司"},"accounts":[{"id":3,"accountName":"中行"}]}]*/
//    @RequestMapping("/getUsers")
//    public List<UserEntity> getUsers() {
//        List<UserEntity> users=userMapper.getAll();
//        return users;
//    }


}