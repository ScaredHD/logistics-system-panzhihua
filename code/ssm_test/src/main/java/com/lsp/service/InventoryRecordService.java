package com.lsp.service;

import com.lsp.domain.InventoryRecord;

public interface InventoryRecordService {
    public boolean AddComment(InventoryRecord inventoryRecord);
    public InventoryRecord GetComment(InventoryRecord inventoryRecord);
}
