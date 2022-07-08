package com.lsp.service;

import com.lsp.domain.Goods;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface GoodsService {
    public boolean AddGoodsInfo(Goods goods);
    public boolean UpdateGoodsInfo(Goods goods);
    public boolean DeleteGoodsInfo(Integer goods_id);
    public List<Goods> SearchByGoodsName(String search);
    public List<Goods> DisplayGoodsInfo();
}
