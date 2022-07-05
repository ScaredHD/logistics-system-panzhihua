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
    public Result AddComment(@RequestBody InventoryRecord inventoryRecord){
        boolean flag = inventoryRecordService.AddComment(inventoryRecord);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping("/comments")
    public Result GetComment(@RequestBody InventoryRecord inventoryRecord){
        InventoryRecord inventoryRecord1 = inventoryRecordService.GetComment(inventoryRecord);
        Integer code = inventoryRecord1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = inventoryRecord1 != null ? "":"No such record!";
        return new Result(code,inventoryRecord1,msg);
    }
    @GetMapping
    public Result DisplayInventoryRecordInfo() {
        List<InventoryRecord> inventoryRecordList = inventoryRecordService.DisplayInventoryRecord();
        Integer code = inventoryRecordList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = inventoryRecordList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,inventoryRecordList,msg);
    }
}
