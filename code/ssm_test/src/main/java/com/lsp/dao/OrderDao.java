package com.lsp.dao;

import com.lsp.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderDao {
    @Insert("insert into order (o_inventory_id,o_company_id,order_created_at,order_desc,order_num,order_status) " +
            "values(#{o_inventory_id},#{o_company_id},#{order_created_at},#{order_desc},#{order_num},#{order_status})")
    public void save(Order order);
    @Update("update order set order_status = #{order_status} where order_id = #{order_id}")
    public void complete(Order order);
    @Select("select * from order")
    public List<Order> getAll();
}
