package com.lsp.dao;

import com.lsp.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where user_email=#{user_email} and password=#{password}")
    public User selectUser(String user_email, String password);
}
