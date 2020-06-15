package com.sgcai.boot.impl;

import com.sgcai.boot.criteria.UserCriteria;
import com.sgcai.boot.dao.UserMapper;
import com.sgcai.boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    @Autowired
    private UserMapper userMapper;

    public  List<User> getUserInfoByMobileWithPwd(String mobile, String password) {
        UserCriteria userCriteria= new UserCriteria();
        userCriteria.setMobile(mobile);
        userCriteria.setPassword(password);
        return userMapper.selectByCriteria(userCriteria);
    }
}
