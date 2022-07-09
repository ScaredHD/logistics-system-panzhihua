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
    @Select("select * from inventory_record")
    public List<InventoryRecord> getAll();
    @Select("select * from inventory_record where ir_warehouse_id=#{ir_warehouse_id}")
    public List<InventoryRecord> getRecordByWarehouseId(String ir_warehouse_id);
}
