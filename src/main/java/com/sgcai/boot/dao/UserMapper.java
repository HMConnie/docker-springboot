package com.sgcai.boot.dao;

import com.sgcai.boot.criteria.UserCriteria;
import com.sgcai.boot.entity.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User lockSelectByPrimaryKey(String id);

    List<User> selectByCriteria(UserCriteria userCriteria);
}