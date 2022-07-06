package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Vehicle;
import com.lsp.domain.Warehouse;
import com.lsp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月04日 14:55:04
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    @PostMapping
    public Result AddWarehouseInfo(@RequestBody Warehouse warehouse) {
        boolean flag = warehouseService.AddWarehouseInfo(warehouse);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @GetMapping("/{warehouse_id}")
    public Result GetById(@PathVariable Integer warehouse_id) {
        Warehouse warehouse = warehouseService.GetById(warehouse_id);
        Integer code = warehouse != null ? Code.GET_OK : Code.GET_ERR;
        String msg = warehouse != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,warehouse,msg);
    }
    @GetMapping
    public Result DisplayWarehouseInfo() {
        List<Warehouse> warehouseList = warehouseService.DisplayWarehouseInfo();
        Integer code = warehouseList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = warehouseList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,warehouseList,msg);
    }
}
