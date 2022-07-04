package com.lsp.controller;

import com.lsp.domain.User;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author:
 * @createTime: 2022年07月02日 09:58:14
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(String user_email, String password, HttpSession httpSession){
        System.out.println("login加载了");
        User user=userService.selectUser(user_email,password);
        System.out.println("select执行了");
        if(user!=null){
            System.out.println("user找到了");
            httpSession.setAttribute("username",user);
            System.out.println("成功登录");
            return "redirect:/html/list.html";
        }
        System.out.println("user没找到");
        return "redirect:/html/login.html";
    }
    @PostMapping("/login1")
    public User login1(String user_email, String password){
        
        return userService.selectUser("heyuhang@qq.com","123");

    }


}
