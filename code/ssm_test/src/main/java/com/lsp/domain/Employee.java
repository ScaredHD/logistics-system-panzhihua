package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月03日 14:00:41
 * @version: 1.0
 * @Description:
 */
public class Employee {
    private Integer employee_id;
    private String employee_name;
    private String employee_gender;
    private String employee_id_card;
    private String employee_tel;
    private String employee_address;
    private char employee_isvisible;

    public char getEmployee_isvisible() {
        return employee_isvisible;
    }

    public void setEmployee_isvisible(char employee_isvisible) {
        this.employee_isvisible = employee_isvisible;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_gender='" + employee_gender + '\'' +
                ", employee_id_card='" + employee_id_card + '\'' +
                ", employee_tel='" + employee_tel + '\'' +
                ", employee_address='" + employee_address + '\'' +
                '}';
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public String getEmployee_tel() {
        return employee_tel;
    }

    public void setEmployee_tel(String employee_tel) {
        this.employee_tel = employee_tel;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }
}
