package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月03日 15:23:34
 * @version: 1.0
 * @Description:
 */
public class Inventory {
    private Integer inventory_id;
    private Integer i_warehouse_id;
    private Integer i_goods_id;
    private Integer inventory_count;

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", i_warehouse_id=" + i_warehouse_id +
                ", i_goods_id=" + i_goods_id +
                ", inventory_count=" + inventory_count +
                '}';
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getI_warehouse_id() {
        return i_warehouse_id;
    }

    public void setI_warehouse_id(Integer i_warehouse_id) {
        this.i_warehouse_id = i_warehouse_id;
    }

    public Integer getI_goods_id() {
        return i_goods_id;
    }

    public void setI_goods_id(Integer i_goods_id) {
        this.i_goods_id = i_goods_id;
    }

    public Integer getInventory_count() {
        return inventory_count;
    }

    public void setInventory_count(Integer inventory_count) {
        this.inventory_count = inventory_count;
    }
}
