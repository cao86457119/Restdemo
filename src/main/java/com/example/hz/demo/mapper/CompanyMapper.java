//package com.example.hz.demo.mapper;
//
//import com.example.hz.demo.entity.Company;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Service;
//
//@Mapper
//@Service
//public interface CompanyMapper {
//    /**
//     * 根据公司id查询公司信息
//     */
//    @Select("SELECT * FROM company WHERE id = #{id}")
//    @Results({
//        @Result(property = "companyName",  column = "name")
//    })
//    Company getCompanyById(Long id);
//}