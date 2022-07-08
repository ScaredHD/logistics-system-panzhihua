package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Delivery;
import com.lsp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月06日 14:33:10
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @PostMapping
    public Result AddDeliveryInfo(Delivery delivery){
        boolean flag = deliveryService.AddDeliveryInfo(delivery);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result UpdateDeliveryInfo(Delivery delivery){
        boolean flag = deliveryService.UpdateDeliveryInfo(delivery);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping
    public Result DisplayDeliveryInfo(){
        List<Delivery> deliveryList = deliveryService.DisplayDeliveryInfo();
        Integer code = deliveryList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = deliveryList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,deliveryList,msg);
    }
}
