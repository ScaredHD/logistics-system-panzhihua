package com.lsp.service;

import com.lsp.domain.InventoryRecord;

import java.util.List;

public interface InventoryRecordService {
    public boolean AddInventoryRecordInfo(InventoryRecord inventoryRecord);
    public List<InventoryRecord> DisplayInventoryRecord();
    public List<InventoryRecord> getRecordByWarehouseId(String ir_warehouse_id);
}
