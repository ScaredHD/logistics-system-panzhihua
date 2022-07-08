package com.lsp.service;

import com.lsp.domain.InventoryRecord;

import java.util.List;

public interface InventoryRecordService {
    public boolean AddComment(InventoryRecord inventoryRecord);
    public InventoryRecord GetComment(InventoryRecord inventoryRecord);
    public List<InventoryRecord> DisplayInventoryRecord();
    public List<InventoryRecord> getRecordByWarehouseId(String id);
}
