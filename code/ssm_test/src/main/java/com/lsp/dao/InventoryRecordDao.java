package com.lsp.dao;

import com.lsp.domain.InventoryRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InventoryRecordDao {
    @Insert("insert into inventory_record (inventory_record_id,ir_warehouse_id,ir_goods_id,record_created_at,record_count," +
            "record_type,record_comments) values(#{inventory_record_id},#{ir_warehouse_id},#{ir_goods_id},#{record_created_at}," +
            "#{record_count},#{record_type},#{record_comments})")
    public void save(InventoryRecord inventoryRecord);
    @Update("update inventory_record comment = #{comment} where inventory_record_id = #{inventory_record_id}")
    public void comment(InventoryRecord inventoryRecord);
    @Select("select * from inventory_record where inventory_record_id = #{inventory_record_id}")
    public InventoryRecord getComment(InventoryRecord inventoryRecord);
    @Select("select * from inventory_record")
    public List<InventoryRecord> getAll();
}
