package com.lsp.service.impl;

import com.lsp.dao.InventoryDao;
import com.lsp.domain.Inventory;
import com.lsp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                return 1;
            }
        }
        inventoryDao.save(inventory);
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
                        return 1;
                    }
                    inventory.setInventory_count(i_count+inventory1.getInventory_count());
                    inventoryDao.update(inventory);
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
