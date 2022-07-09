package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Inventory;
import com.lsp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月04日 14:55:28
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/inventorys")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @PostMapping("/store")
    public Result Store(@RequestBody Inventory inventory) {
        Integer flag = inventoryService.Store(inventory);
        if(flag.equals(1)){
            return new Result(Code.UPDATE_OK,flag);
        }
        else if(flag.equals(2)){
            return new Result(Code.SAVE_OK,flag);
        }
        else{
            return new Result(Code.STORE_ERR,flag);
        }
    }
    @PostMapping("/withdraw")
    public Result withDraw(@RequestBody Inventory inventory){
        Integer flag = inventoryService.withDraw(inventory);
        if(flag.equals(1)){
            return new Result(Code.DELETE_OK,flag);
        }
        else if(flag.equals(2)){
            return new Result(Code.UPDATE_OK,flag);
        }
        else if(flag.equals(3)){
            String msg = "库存不足！";
            return new Result(Code.WITHDRAW_ERR,flag,msg);
        }
        else if(flag.equals(4)){
            String msg = "无存储！";
            return new Result(Code.WITHDRAW_ERR,flag,msg);
        }else{
            return new Result(Code.WITHDRAW_ERR,flag);
        }
    }
    @GetMapping
    public Result DisplayInventoryInfo() {
        List<Inventory> inventoryList = inventoryService.DisplayInventoryInfo();
        Integer code = inventoryList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = inventoryList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,inventoryList,msg);
    }
}
