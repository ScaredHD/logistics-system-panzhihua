package com.lsp.dao;

import com.lsp.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDao {
    //    @Select("select * from user where user_email=#{user_email} and password=#{password}")
//    public List<User> selectUsers(String user_email,String password);
    @Select("select * from user where user_email = #{user_email} and password = #{password}")
    public User selectUserByEml(User user);

    @Select("select * from user where user_email = #{user_email}")
    public User emailVery(String user_email);

    @Select("select * from user where activation_code = #{activation_code}")
    public User selectActivationCode(String activationCode);

    @Update("update user set user_email = #{user_email},password = #{password},state = #{state} where activation_code=#{activation_code}")
    public void registerUser(User user);

    @Select("select * from user")
    public List<User> displayUser();

}