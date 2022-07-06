package com.lsp.controller;

import com.lsp.domain.User;
import com.lsp.service.UserService;
import com.lsp.utils.EmalUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author:
 * @createTime: 2022年07月02日 09:58:14
 * @version: 1.0
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(String user_email,
                        String password,
                        HttpSession httpSession) {
        Result result=new Result();
        User userIn = new User(user_email, password);
        System.out.println("login加载了");
        User user = userService.selectUserByEml(userIn);
        System.out.println("select执行了");
        if (user != null) {
            System.out.println("user找到了");
            httpSession.setAttribute("user", user);
            System.out.println("成功登录");
            result.setCode(Code.GET_OK);
            result.setData(user);
            result.setMsg("登录成功");
            return result;
        }
        //System.out.println("user没找到");
        result.setMsg("登录失败");
        result.setCode(Code.GET_ERR);
        return result;
    }
    @PostMapping("/getVerify")
    public Result getVerify(String email,HttpSession httpSession){
        Result result=new Result();
        String yzm= EmalUtils.sendEmail(email);
        httpSession.setAttribute(email,yzm);
        result.setCode(Code.GET_OK);
        result.setData(yzm);
        result.setMsg("获取验证码成功");
        return result;
    }
    @PostMapping("/loginByEmail")
    public Result loginByEmail(String email,String verify,HttpSession httpSession){
        User user=userService.emailVery(email);
        Result result=new Result();
        if(user!=null){
            if(verify.equals(httpSession.getAttribute(email))){
                httpSession.setAttribute("user", user);
                result.setMsg("登录成功");
                result.setCode(Code.GET_OK);
                result.setData(user);
                return result;
            }
        }
        result.setCode(Code.GET_ERR);
        result.setMsg("登录失败");
        return result;

    }
    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(String user_email, String password, HttpSession httpSession) {
        httpSession.removeAttribute("user");
        if(httpSession.getAttribute("user")==null){
            return true;
        }
        else return false;
    }

    @PostMapping("/register")
    @ResponseBody
    public boolean register(String user_email, String password, String activation_code) {
        User user =userService.selectActivationCode(activation_code);
        if(user!=null){
            user.setUser_email(user_email);
            user.setPassword(password);
            userService.registerUser(user);
            return true;
        }
        else return false;

    }

}

