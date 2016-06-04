package com.jackie.controller;

import com.jackie.model.User;
import com.jackie.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by jackie on 2016/5/17.
 */
@Controller
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 通过验证session里的用户信息
     * 检查当前用户是否已登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/check")
    public
    @ResponseBody
    String check(HttpSession session) {
        log.debug("lalalla");
        User user = (User) session.getAttribute("user");
        if (null != user)
            return user.getUserName();
        log.info("用户没有在session中");
        return null;
    }

    /**
     * 用户登陆操作
     *
     * @param user_name
     * @param user_pwd
     * @param session   登陆成功则写入session
     * @return 登陆成功则返回用户名，失败则返回空字符串
     */
    @RequestMapping("/login")
    public
    @ResponseBody
    String login(
            @RequestParam("user_name") String user_name, @RequestParam("user_pwd") String user_pwd,
            HttpSession session) {
        User user = userService.login(user_name);
        if (null != user && user_pwd.equals(user.getUserPassword())) {
            //验证成功
            session.setAttribute("user", user);
//            model.addAttribute("user", user);
            log.info("用户" + user.getUserName() + "登陆成功");
            return user.getUserName();
        } else {
            log.info("用户" + user_name + "登陆失败");
            return "";
        }
    }
}
