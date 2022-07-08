package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月03日 10:59:08
 * @version: 1.0
 * @Description:
 */
public class Driver {
    private Integer driver_id;
    private String driver_name;
    private String driver_gender;
    private String driver_tel;
    private String driver_license;
    private String driver_id_card;
    private Integer driver_license_score;
    private String driver_address;
    private char driver_status;

    @Override
    public String toString() {
        return "Driver{" +
                "driver_id=" + driver_id +
                ", driver_name='" + driver_name + '\'' +
                ", driver_gender='" + driver_gender + '\'' +
                ", driver_tel='" + driver_tel + '\'' +
                ", driver_license='" + driver_license + '\'' +
                ", driver_id_card='" + driver_id_card + '\'' +
                ", driver_license_score=" + driver_license_score +
                ", driver_address='" + driver_address + '\'' +
                ", driver_status=" + driver_status +
                '}';
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_gender() {
        return driver_gender;
    }

    public void setDriver_gender(String driver_gender) {
        this.driver_gender = driver_gender;
    }

    public String getDriver_tel() {
        return driver_tel;
    }

    public void setDriver_tel(String driver_tel) {
        this.driver_tel = driver_tel;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getDriver_id_card() {
        return driver_id_card;
    }

    public void setDriver_id_card(String driver_id_card) {
        this.driver_id_card = driver_id_card;
    }

    public Integer getDriver_license_score() {
        return driver_license_score;
    }

    public void setDriver_license_score(Integer driver_license_score) {
        this.driver_license_score = driver_license_score;
    }

    public String getDriver_address() {
        return driver_address;
    }

    public void setDriver_address(String driver_address) {
        this.driver_address = driver_address;
    }

    public char getDriver_status() {
        return driver_status;
    }

    public void setDriver_status(char driver_status) {
        this.driver_status = driver_status;
    }
}
