package com.lsp.domain;

import java.sql.Timestamp;

/**
 * @Author:
 * @createTime: 2022年07月05日 09:39:59
 * @version:
 * @Description:
 */
public class Delivery {
    private Integer deliver_id;
    private Integer d_driver_id;
    private Integer d_vehicle_id;
    private Integer d_order_id;
    private Timestamp deliver_time;
    private String deliver_address;
    private char deliver_status;
    private String deliver_notice;

    @Override
    public String toString() {
        return "Delivery{" +
                "deliver_id=" + deliver_id +
                ", d_driver_id=" + d_driver_id +
                ", d_vehicle_id=" + d_vehicle_id +
                ", d_order_id=" + d_order_id +
                ", deliver_time=" + deliver_time +
                ", deliver_address='" + deliver_address + '\'' +
                ", deliver_status=" + deliver_status +
                ", deliver_notice='" + deliver_notice + '\'' +
                '}';
    }

    public Integer getDeliver_id() {
        return deliver_id;
    }

    public void setDeliver_id(Integer deliver_id) {
        this.deliver_id = deliver_id;
    }

    public Integer getD_driver_id() {
        return d_driver_id;
    }

    public void setD_driver_id(Integer d_driver_id) {
        this.d_driver_id = d_driver_id;
    }

    public Integer getD_vehicle_id() {
        return d_vehicle_id;
    }

    public void setD_vehicle_id(Integer d_vehicle_id) {
        this.d_vehicle_id = d_vehicle_id;
    }

    public Integer getD_order_id() {
        return d_order_id;
    }

    public void setD_order_id(Integer d_order_id) {
        this.d_order_id = d_order_id;
    }

    public Timestamp getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(Timestamp deliver_time) {
        this.deliver_time = deliver_time;
    }

    public String getDeliver_address() {
        return deliver_address;
    }

    public void setDeliver_address(String deliver_address) {
        this.deliver_address = deliver_address;
    }

    public char getDeliver_status() {
        return deliver_status;
    }

    public void setDeliver_status(char deliver_status) {
        this.deliver_status = deliver_status;
    }

    public String getNotice() {
        return deliver_notice;
    }

    public void setNotice(String deliver_notice) {
        this.deliver_notice = deliver_notice;
    }
}
