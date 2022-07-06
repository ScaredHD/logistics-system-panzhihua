package com.lsp.dao;

import com.lsp.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Insert("insert into order (o_inventory_id,o_company_id,order_created_at,order_desc,order_num) " +
            "values(#{o_inventory_id},#{o_company_id},#{order_created_at},#{order_desc},#{order_num})")
    public void save(Order order);
    @Select("select * from order")
    public List<Order> getAll();
}
