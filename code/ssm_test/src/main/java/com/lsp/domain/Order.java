package com.lsp.domain;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Author:
 * @createTime: 2022年07月05日 09:36:07
 * @version:
 * @Description:
 */
public class Order {
    private Integer order_id;
    private Integer o_goods_id;
    private Integer o_company_id;
    private Timestamp order_created_at;
    private String order_desc;
    private Integer order_num;
    private char order_status;
    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", o_goods_id=" + o_goods_id +
                ", o_company_id=" + o_company_id +
                ", order_created_at=" + order_created_at +
                ", order_desc='" + order_desc + '\'' +
                ", order_num=" + order_num +
                ", order_status=" + order_status +
                '}';
    }

    public char getOrder_status() {
        return order_status;
    }

    public void setOrder_status(char order_status) {
        this.order_status = order_status;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getO_goods_id() {
        return o_goods_id;
    }

    public void setO_goods_id(Integer o_goods_id) {
        this.o_goods_id = o_goods_id;
    }

    public Integer getO_company_id() {
        return o_company_id;
    }

    public void setO_company_id(Integer o_company_id) {
        this.o_company_id = o_company_id;
    }

    public Timestamp getOrder_created_at() {
        return order_created_at;
    }

    public void setOrder_created_at(Timestamp order_created_at) {
        this.order_created_at = order_created_at;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }
}
