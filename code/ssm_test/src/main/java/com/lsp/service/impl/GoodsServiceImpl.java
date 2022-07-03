package com.lsp.service.impl;

import com.lsp.dao.GoodsDao;
import com.lsp.domain.Goods;
import com.lsp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 10:12:09
 * @version: 1.0
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    public boolean AddGoodsInfo(Goods goods) {
        goodsDao.save(goods);
        return true;
    }

    public boolean UpdateGoodsInfo(Goods goods) {
        goodsDao.update(goods);
        return true;
    }

    public boolean DeleteGoodsInfo(Integer goods_id) {
        goodsDao.delete(goods_id);
        return true;
    }

    public List<Goods> SearchByGoodsName(String search) {
        return goodsDao.GetByName(search);
    }

    public List<Goods> DisplayGoodsInfo() {
        return goodsDao.getAll();
    }
}
