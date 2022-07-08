package com.lsp.domain;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Author:
 * @createTime: 2022年07月04日 09:22:45
 * @version: 1.0
 * @Description:
 */
public class InventoryRecord {
    private Integer inventory_record_id;
    private Integer ir_warehouse_id;
    private Integer ir_goods_id;
    private Timestamp record_created_at;
    private Integer record_count;
    private char record_type;
    private String record_comments;

    @Override
    public String toString() {
        return "InventoryRecord{" +
                "inventory_record_id=" + inventory_record_id +
                ", ir_warehouse_id=" + ir_warehouse_id +
                ", ir_goods_id=" + ir_goods_id +
                ", record_create_at=" + record_created_at +
                ", record_count=" + record_count +
                ", record_type=" + record_type +
                ", record_comments='" + record_comments + '\'' +
                '}';
    }

    public Integer getInventory_record_id() {
        return inventory_record_id;
    }

    public void setInventory_record_id(Integer inventory_record_id) {
        this.inventory_record_id = inventory_record_id;
    }

    public Integer getIr_warehouse_id() {
        return ir_warehouse_id;
    }

    public void setIr_warehouse_id(Integer ir_warehouse_id) {
        this.ir_warehouse_id = ir_warehouse_id;
    }

    public Integer getIr_goods_id() {
        return ir_goods_id;
    }

    public void setIr_goods_id(Integer ir_goods_id) {
        this.ir_goods_id = ir_goods_id;
    }

    public String getRecord_created_at() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
        String str = df.format(record_created_at);
        return str;
        //return record_created_at;
    }

    public void setRecord_created_at(Timestamp record_created_at) {
        this.record_created_at = record_created_at;
    }

    public Integer getRecord_count() {
        return record_count;
    }

    public void setRecord_count(Integer record_count) {
        this.record_count = record_count;
    }

    public char getRecord_type() {
        return record_type;
    }

    public void setRecord_type(char record_type) {
        this.record_type = record_type;
    }

    public String getRecord_comments() {
        return record_comments;
    }

    public void setRecord_comments(String record_comments) {
        this.record_comments = record_comments;
    }
}
