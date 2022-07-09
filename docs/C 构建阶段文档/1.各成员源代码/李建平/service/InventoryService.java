package com.lsp.service;

import com.lsp.domain.Inventory;

import java.util.List;

public interface InventoryService {
    public Integer Store(Inventory inventory);
    public Integer withDraw(Inventory inventory);
    public List<Inventory> DisplayInventoryInfo();
}
