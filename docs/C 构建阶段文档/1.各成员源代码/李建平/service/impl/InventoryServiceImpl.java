package com.lsp.service.impl;

import com.lsp.dao.InventoryDao;
import com.lsp.dao.InventoryRecordDao;
import com.lsp.domain.Inventory;
import com.lsp.domain.InventoryRecord;
import com.lsp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static java.lang.Math.abs;

/**
 * @Author:
 * @createTime: 2022年07月04日 11:40:40
 * @version:
 * @Description:
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private InventoryRecordDao inventoryRecordDao;
    public Integer Store(Inventory inventory) {
        Integer w_id = inventory.getI_warehouse_id();
        Integer g_id = inventory.getI_goods_id();
        Integer i_count = inventory.getInventory_count();
        List<Inventory> inventoryList = inventoryDao.getAll();
        for(int i = 0;i<inventoryList.size();i++){
            Inventory inventory1 = inventoryList.get(i);
            if((inventory1.getI_goods_id().equals(g_id))&&(inventory1.getI_warehouse_id().equals(w_id))){
                inventory.setInventory_count(i_count+inventory1.getInventory_count());
                inventoryDao.update(inventory);
                InventoryRecord inventoryRecord = null;
                inventoryRecord.setIr_warehouse_id(w_id);
                inventoryRecord.setIr_goods_id(g_id);
                inventoryRecord.setRecord_count(i_count);
                inventoryRecord.setRecord_type('1');
                Timestamp timeStamp= new Timestamp(System.currentTimeMillis());
                inventoryRecord.setRecord_create_at(timeStamp);
                inventoryRecord.setRecord_comments("成功入库！");
                inventoryRecordDao.save(inventoryRecord);
                return 1;
            }
        }
        inventoryDao.save(inventory);
        InventoryRecord inventoryRecord = null;
        inventoryRecord.setIr_warehouse_id(w_id);
        inventoryRecord.setIr_goods_id(g_id);
        inventoryRecord.setRecord_count(i_count);
        inventoryRecord.setRecord_type('1');
        Timestamp timeStamp= new Timestamp(System.currentTimeMillis());
        inventoryRecord.setRecord_create_at(timeStamp);
        inventoryRecord.setRecord_comments("成功入库！");
        inventoryRecordDao.save(inventoryRecord);
        return 2;
    }

    public Integer withDraw(Inventory inventory) {
        Integer w_id = inventory.getI_warehouse_id();
        Integer g_id = inventory.getI_goods_id();
        Integer i_count = inventory.getInventory_count();
        List<Inventory> inventoryList = inventoryDao.getAll();
        for(int i = 0;i<inventoryList.size();i++){
            Inventory inventory1 = inventoryList.get(i);
            if((inventory1.getI_goods_id().equals(g_id))&&(inventory1.getI_warehouse_id().equals(w_id))){
                if(i_count+inventory1.getInventory_count() >= 0){
                    if(i_count+inventory1.getInventory_count() == 0){
                        inventoryDao.delete(w_id,g_id);
                        InventoryRecord inventoryRecord = null;
                        inventoryRecord.setIr_warehouse_id(w_id);
                        inventoryRecord.setIr_goods_id(g_id);
                        inventoryRecord.setRecord_count(abs(i_count));
                        inventoryRecord.setRecord_type('2');
                        Timestamp timeStamp= new Timestamp(System.currentTimeMillis());
                        inventoryRecord.setRecord_create_at(timeStamp);
                        inventoryRecord.setRecord_comments("成功出库！");
                        inventoryRecordDao.save(inventoryRecord);
                        return 1;
                    }
                    inventory.setInventory_count(i_count+inventory1.getInventory_count());
                    inventoryDao.update(inventory);
                    InventoryRecord inventoryRecord = null;
                    inventoryRecord.setIr_warehouse_id(w_id);
                    inventoryRecord.setIr_goods_id(g_id);
                    inventoryRecord.setRecord_count(abs(i_count));
                    inventoryRecord.setRecord_type('2');
                    Timestamp timeStamp= new Timestamp(System.currentTimeMillis());
                    inventoryRecord.setRecord_create_at(timeStamp);
                    inventoryRecord.setRecord_comments("成功出库！");
                    inventoryRecordDao.save(inventoryRecord);
                    return 2;
                }
                else{
                    return 3;
                }
            }
        }
        return 4;
    }

    public List<Inventory> DisplayInventoryInfo() {
        return inventoryDao.getAll();
    }
}
