package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月03日 15:21:03
 * @version: 1.0
 * @Description:
 */
public class Warehouse {
    private Integer warehouse_id;
    private String warehouse_name;
    private Integer warehouse_manager_id;

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouse_id=" + warehouse_id +
                ", warehouse_name='" + warehouse_name + '\'' +
                ", warehouse_manager_id=" + warehouse_manager_id +
                '}';
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public Integer getWarehouse_manager_id() {
        return warehouse_manager_id;
    }

    public void setWarehouse_manager_id(Integer warehouse_manager_id) {
        this.warehouse_manager_id = warehouse_manager_id;
    }
}
