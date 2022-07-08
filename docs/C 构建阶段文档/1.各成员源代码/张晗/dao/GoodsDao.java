package com.lsp.dao;

import com.lsp.domain.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsDao {
    @Insert("insert into goods (goods_name,goods_desc,goods_price) " +
            "values(#{goods_name},#{goods_desc},#{goods_price})")
    public void save(Goods goods);
    @Update("update goods set goods_name = #{goods_name},goods_desc = #{goods_desc},goods_price=#{goods_price} " +
            "where goods_id = #{goods_id}")
    public void update(Goods goods);
    @Delete("delete from goods where goods_id = #{goods_id}")
    public void delete(Integer goods_id);
    @Select("select goods_id,goods_name,goods_desc,goods_price from goods " +
            "where goods_name like concat('%',#{search},'%')")
    public List<Goods> GetByName(String search);
    @Select("select * from goods")
    public List<Goods> getAll();
}
