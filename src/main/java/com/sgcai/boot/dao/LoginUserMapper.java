package com.sgcai.boot.dao;

import com.sgcai.boot.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginUserMapper {
    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser lockSelectByPrimaryKey();
}