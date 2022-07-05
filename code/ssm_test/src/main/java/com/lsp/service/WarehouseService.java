package com.lsp.service;

import com.lsp.domain.Warehouse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WarehouseService {
    public boolean AddWarehouseInfo(Warehouse warehouse);
    public Warehouse GetById(Integer warehouse_id);
    public List<Warehouse> DisplayWarehouseInfo();
}
