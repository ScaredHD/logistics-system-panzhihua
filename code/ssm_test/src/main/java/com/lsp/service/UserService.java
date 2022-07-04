package com.lsp.service;

import com.lsp.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    User selectUser(String user_email,String password);
}
