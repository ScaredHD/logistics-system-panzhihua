package com.lsp.service;

import com.lsp.domain.User;

<<<<<<< HEAD
import java.util.List;

@Transactional
public interface UserService {
    //    public List<User> selectUsers(String user_email,String password);
    User selectUserByEml(User user);
    List<User> displayUser();
    public User emailVery(String user_email);
    public User selectActivationCode(String activationCode);
    public void registerUser(User user);
=======
public interface UserService {
    public User selectUser(String user_email, String password);
>>>>>>> 58a9bcff34d3462a6900369747b653524fdf0b25
}
