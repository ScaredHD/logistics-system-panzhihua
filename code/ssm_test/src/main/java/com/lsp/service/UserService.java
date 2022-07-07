package com.lsp.service;

import com.lsp.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    //    public List<User> selectUsers(String user_email,String password);
    User selectUserByEml(User user);
    List<User> displayUser();
    public User emailVery(String user_email);
    public User selectActivationCode(String activationCode);
    public void registerUser(User user);
}