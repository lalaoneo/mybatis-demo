package com.lori.mybatisdemo.service.impl;

import com.lori.mybatisdemo.dao.UserMapper;
import com.lori.mybatisdemo.domain.User;
import com.lori.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        int result = userMapper.insert(user);
        Assert.isTrue(result == 1,"保存失败");
    }
}
