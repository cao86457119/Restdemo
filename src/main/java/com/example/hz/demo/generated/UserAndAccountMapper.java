package com.example.hz.demo.generated;

import com.example.hz.demo.entity.UserEntity;

import java.util.List;

/**
 * @author kiva
 */
public interface UserAndAccountMapper {
    List<UserEntity> selectUserWithAccountById(int id);
}
