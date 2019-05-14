//package com.example.hz.demo.mapper;
//
//import com.example.hz.demo.entity.UserEntity;
//import com.example.hz.demo.entity.UserSexEnum;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author kiva
// */
//@Mapper
//@Service
//public interface UserMapper {
//
//	/**
//	 * 一对一查询
//	 * property：查询结果赋值给此实体属性
//	 * column：对应数据库的表字段，做为下面@One(select方法的查询参数
//	 * one：一对一的查询
//	 * @One(select = 方法全路径) ：调用的方法
//	 */
//	@Select("SELECT * FROM user WHERE id = #{id}")
//	@Results({
//			@Result(property = "company", column = "company_id", one = @One(select = "com.example.hz.demo.mapper.CompanyMapper.getCompanyById"))
//	})
//	UserEntity getUserWithCompany(Long id);
//
//	/**
//	 * 一对多查询
//	 * property：查询结果赋值给此实体属性
//	 * column：对应数据库的表字段，可做为下面@One(select方法)的查询参数
//	 * many：一对多的查询
//	 * @Many(select = 方法全路径) ：调用的方法
//	 */
//	@Select("SELECT * FROM user WHERE id = #{id}")
//	@Results({
//			@Result(property = "id", column = "id"),//加此行，否则id值为空
//			@Result(property = "accounts", column = "id", many = @Many(select = "com.example.hz.demo.mapper.AccountMapper.getAccountByUserId"))
//	})
//	UserEntity getUserWithAccount(Long id);
//
//	/**
//	 * 同时用一对一、一对多查询
//	 */
//	@Select("SELECT * FROM user")
//	@Results({
//			@Result(property = "id", column = "id"),
//			@Result(property = "company", column = "company_id", one = @One(select = "com.example.hz.demo.mapper.CompanyMapper.getCompanyById")),
//			@Result(property = "accounts", column = "id", many = @Many(select = "com.example.hz.demo.mapper.AccountMapper.getAccountByUserId"))
//	})
//	List<UserEntity> getAll();
//}