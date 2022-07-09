package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.InventoryRecord;
import com.lsp.service.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月04日 16:26:32
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/inventoryRecords")
public class InventoryRecordController {
    @Autowired
    private InventoryRecordService inventoryRecordService;
    @PostMapping
    public Result AddInventoryRecordInfo(@RequestBody InventoryRecord inventoryRecord){
        boolean flag = inventoryRecordService.AddInventoryRecordInfo(inventoryRecord);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping("/{ir_warehouse_id}")
    public Result GetByWarehouseId(@PathVariable String ir_warehouse_id){
        List<InventoryRecord> inventoryRecordList = inventoryRecordService.getRecordByWarehouseId(ir_warehouse_id);
        Integer code = inventoryRecordList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = inventoryRecordList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,inventoryRecordList,msg);
    }

    @GetMapping
    public Result DisplayInventoryRecordInfo() {
        List<InventoryRecord> inventoryRecordList = inventoryRecordService.DisplayInventoryRecord();
        Integer code = inventoryRecordList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = inventoryRecordList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,inventoryRecordList,msg);
    }
}
