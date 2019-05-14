//package com.example.hz.demo.mapper;
//
//import com.example.hz.demo.entity.Account;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Mapper
//@Service
//public interface AccountMapper {
//    /**
//     * 根据用户id查询账户信息
//     */
//    @Select("SELECT * FROM `account` WHERE user_id = #{userId}")
//    @Results({
//        @Result(property = "accountName",  column = "name")
//    })
//    List<Account> getAccountByUserId(Long userId);
//
//    @Insert("insert into account() values(#{accountName},)")
//    void insertAccount(Account a);
//}