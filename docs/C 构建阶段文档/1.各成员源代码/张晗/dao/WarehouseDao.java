package com.lsp.dao;

import com.lsp.domain.Warehouse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WarehouseDao {
    @Insert("insert into warehouse (warehouse_name,warehouse_manager_id) " +
            "values(#{warehouse_name},#{warehouse_manager_id})")
    public void save(Warehouse warehouse);
    @Select("select * from warehouse where warehouse_id = #{warehouse_id}")
    public Warehouse GetById(Integer  warehouse_id);
    @Select("select * from warehouse")
    public List<Warehouse> getAll();
}
