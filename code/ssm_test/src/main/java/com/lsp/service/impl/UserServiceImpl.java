package com.lsp.service.impl;

import com.lsp.dao.UserDao;
import com.lsp.domain.User;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 09:57:41
 * @version: 1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
<<<<<<< HEAD

    //    public List<User> selectUsers(String user_email, String password) {
//        return userDao.selectUsers(user_email,password);
//
//    }
    public User selectUserByEml(User user){
        return userDao.selectUserByEml(user);
    }

    public List<User> displayUser() {
        return userDao.displayUser();
    }

    public User selectActivationCode(String activationCode) {
        User user=userDao.selectActivationCode(activationCode);
=======
    public User selectUser(String user_email, String password) {
        User user=userDao.selectUser(user_email,password);
>>>>>>> 58a9bcff34d3462a6900369747b653524fdf0b25
        return user;
    }

    public void registerUser(User user) {
        userDao.registerUser(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public User emailVery(String user_email){
        return userDao.emailVery(user_email);
    }
}
