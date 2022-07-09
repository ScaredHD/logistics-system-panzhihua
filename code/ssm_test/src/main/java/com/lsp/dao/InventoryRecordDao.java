package com.lsp.dao;

import com.lsp.domain.InventoryRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InventoryRecordDao {
    @Insert("insert into inventory_record (ir_warehouse_id,ir_goods_id,record_created_at,record_count," +
            "record_type,record_comments) values(#{ir_warehouse_id},#{ir_goods_id},#{record_created_at}," +
            "#{record_count},#{record_type},#{record_comments})")
    public void save(InventoryRecord inventoryRecord);
    @Update("update inventory_record set record_comments = #{record_comments} where inventory_record_id = #{inventory_record_id}")
    public void comment(InventoryRecord inventoryRecord);
    @Select("select * from inventory_record where inventory_record_id = #{inventory_record_id}")
    public InventoryRecord getComment(InventoryRecord inventoryRecord);
    @Select("select * from inventory_record")
    public List<InventoryRecord> getAll();
    @Select("select * from inventory_record where inventory_record_id=#{inventory_record_id}")
    public List<InventoryRecord> getRecordByWarehouseId(String inventory_record_id);
}
