package com.lsp.service.impl;

import com.lsp.dao.InventoryRecordDao;
import com.lsp.domain.InventoryRecord;
import com.lsp.service.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月04日 16:22:29
 * @version:
 * @Description:
 */
@Service
public class InventoryRecordServiceImpl implements InventoryRecordService {
    @Autowired
    private InventoryRecordDao inventoryRecordDao;
    @Override
    public boolean AddInventoryRecordInfo(InventoryRecord inventoryRecord) {
        inventoryRecordDao.save(inventoryRecord);
        return true;
    }
    public List<InventoryRecord> DisplayInventoryRecord() {
        return inventoryRecordDao.getAll();
    }
    public List<InventoryRecord> getRecordByWarehouseId(String ir_warehouse_id){
        return inventoryRecordDao.getRecordByWarehouseId(ir_warehouse_id);
    }
}
