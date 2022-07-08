package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Order;
import com.lsp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月06日 11:15:27
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public Result AddOrderInfo(@RequestBody Order order){
        boolean flag = orderService.AddOrderInfo(order);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result CompleteOrder(@RequestBody Order order){
        boolean flag = orderService.CompleteOrder(order);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping
    public Result DisplayCompanyInfo() {
        List<Order> orderList = orderService.DisplayOrderInfo();
        Integer code = orderList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,orderList,msg);
    }
}
