package com.lsp.service;

import com.lsp.domain.User;

public interface UserService {
    public User selectUser(String user_email, String password);
}
