package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月02日 09:51:30
 * @version: 1.0
 * @Description:
 */
public class User {
    private Integer user_id;
    private String user_email;
    private String password;
    private String activation_code;
    private char state;

    public User(String user_email, String password) {
        this.user_email = user_email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", password='" + password + '\'' +
                ", activation_code='" + activation_code + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
}
