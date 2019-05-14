package com.example.hz.demo.generated;

import com.example.hz.demo.generated.account;
import com.example.hz.demo.generated.accountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface accountMapper {
    long countByExample(accountExample example);

    int deleteByExample(accountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(account record);

    int insertSelective(account record);

    List<account> selectByExample(accountExample example);

    account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") account record, @Param("example") accountExample example);

    int updateByExample(@Param("record") account record, @Param("example") accountExample example);

    int updateByPrimaryKeySelective(account record);

    int updateByPrimaryKey(account record);
}