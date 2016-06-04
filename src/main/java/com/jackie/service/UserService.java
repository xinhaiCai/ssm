package com.jackie.service;

import com.jackie.model.User;

/**
 * Created by jackie on 2016/3/23.
 */

public interface UserService {
    /**
     * 登陆功能
     *
     * @param user_name 用户名
     * @Return 返回根据用户名查询的结果
     */
    User login(String user_name);
}
