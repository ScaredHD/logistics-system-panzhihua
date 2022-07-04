package com.lsp.service;

import com.lsp.domain.Warehouse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WarehouseService {
    public boolean AddWarehouseInfo(Warehouse warehouse);
    public List<Warehouse> DisplayWarehouseInfo();
}
