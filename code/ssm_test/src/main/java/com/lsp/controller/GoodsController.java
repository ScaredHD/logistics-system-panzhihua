package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Goods;
import com.lsp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 10:16:02
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @PostMapping
    public Result AddGoodsInfo(@RequestBody Goods goods) {
        boolean flag = goodsService.AddGoodsInfo(goods);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result UpdateGoodsInfo(@RequestBody Goods goods) {
        boolean flag = goodsService.UpdateGoodsInfo(goods);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{goods_id}")
    public Result DeleteGoodsInfo(@PathVariable Integer goods_id) {
        boolean flag = goodsService.DeleteGoodsInfo(goods_id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @GetMapping("/{search}")
    public Result SearchByGoodsName(@PathVariable String search) {
        List<Goods> goodsList = goodsService.SearchByGoodsName(search);
        Integer code = goodsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = goodsList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,goodsList,msg);
    }
    @GetMapping
    public Result DisplayGoodsInfo() {
        List<Goods> goodsList = goodsService.DisplayGoodsInfo();
        Integer code = goodsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = goodsList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,goodsList,msg);
    }
}
