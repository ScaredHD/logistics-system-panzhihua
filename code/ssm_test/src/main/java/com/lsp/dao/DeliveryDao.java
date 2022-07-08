package com.lsp.dao;

import com.lsp.domain.Delivery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeliveryDao {
    @Insert("insert into delivery (d_driver_id,d_vehicle_id,d_order_id,deliver_time,deliver_address," +
            "deliver_status,deliver_notice) values(#{d_driver_id},#{d_vehicle_id},#{d_order_id},#{deliver_time}," +
            "#{deliver_address},#{deliver_status},#{notice})")
    public void save(Delivery delivery);
    @Update("update delivery set d_driver_id = #{d_driver_id},d_vehicle_id = #{d_vehicle_id}," +
            "d_order_id = #{d_order_id},deliver_time = #{deliver_time},deliver_address = #{deliver_address}," +
            "deliver_status = #{deliver_status},deliver_notice = #{notice} " +
            "where deliver_id = #{deliver_id}")
    public void update(Delivery delivery);
    @Select("select * from delivery")
    public List<Delivery> getAll();
}
