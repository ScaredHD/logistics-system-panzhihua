package com.lsp.service.impl;

import com.lsp.dao.WarehouseDao;
import com.lsp.domain.Warehouse;
import com.lsp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月04日 09:59:05
 * @version: 1.0
 * @Description:
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;
    public boolean AddWarehouseInfo(Warehouse warehouse){
        warehouseDao.save(warehouse);
        return true;
    }

    public List<Warehouse> DisplayWarehouseInfo() {
        return warehouseDao.getAll();
    }

}
