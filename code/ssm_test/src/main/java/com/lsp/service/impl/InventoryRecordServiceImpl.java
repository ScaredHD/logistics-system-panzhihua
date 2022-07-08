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
    public boolean AddComment(InventoryRecord inventoryRecord) {
        inventoryRecordDao.comment(inventoryRecord);
        return true;
    }

    public InventoryRecord GetComment(InventoryRecord inventoryRecord) {
        return inventoryRecordDao.getComment(inventoryRecord);
    }

    public List<InventoryRecord> DisplayInventoryRecord() {
        return inventoryRecordDao.getAll();
    }

    public List<InventoryRecord> getRecordByWarehouseId(String id){
        return inventoryRecordDao.getRecordByWarehouseId(id);
    }
}
