package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月02日 21:43:18
 * @version: 1.0
 * @Description:
 */
public class Vehicle {
    private Integer vehicle_id;
    private String vehicle_license_number;
    private String vehicle_type;
    private char vehicle_status;

    @Override
    public String toString() {
        return "vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_license_number='" + vehicle_license_number + '\'' +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", vehicle_status=" + vehicle_status +
                '}';
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_license_number() {
        return vehicle_license_number;
    }

    public void setVehicle_license_number(String vehicle_license_number) {
        this.vehicle_license_number = vehicle_license_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public char getVehicle_status() {
        return vehicle_status;
    }

    public void setVehicle_status(char vehicle_status) {
        this.vehicle_status = vehicle_status;
    }
}
