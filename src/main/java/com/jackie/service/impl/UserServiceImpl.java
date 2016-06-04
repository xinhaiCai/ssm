package com.jackie.service.impl;

import com.jackie.dao.UserMapper;
import com.jackie.model.User;
import com.jackie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jackie on 2016/5/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public User login(String user_name) {
        return userDao.selectByUserName(user_name);
    }
}
