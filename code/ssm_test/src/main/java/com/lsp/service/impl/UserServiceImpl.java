package com.lsp.service.impl;

import com.lsp.dao.UserDao;
import com.lsp.dao.VehicleDao;
import com.lsp.domain.User;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User selectUser(String user_email, String password) {
        User user=userDao.selectUser(user_email,password);
        return user;
    }
}
