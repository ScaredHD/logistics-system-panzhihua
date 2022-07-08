package com.lsp.dao;

import com.lsp.domain.Inventory;
import com.lsp.domain.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InventoryDao {
    @Insert("insert into inventory (i_warehouse_id,i_goods_id,inventory_count) " +
            "values(#{i_warehouse_id},#{i_goods_id},#{inventory_count})")
    public void save(Inventory inventory);
    @Update("update inventory set inventory_count = #{inventory_count} " +
            "where i_warehouse_id = #{i_warehouse_id} and i_goods_id = #{i_goods_id}")
    public void update(Inventory inventory);
    @Delete("delete from inventory where i_warehouse_id = #{i_warehouse_id} and i_goods_id = #{i_goods_id}")
    public void delete(Integer i_warehouse_id,Integer i_goods_id);
    @Select("select * from inventory")
    public List<Inventory> getAll();
}
