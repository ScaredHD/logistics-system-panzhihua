package com.lsp.dao;

import com.lsp.domain.Vehicle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VehicleDao {
    @Insert("insert into vehicle (vehicle_license_number,vehicle_type,vehicle_status) " +
            "values(#{vehicle_license_number},#{vehicle_type},#{vehicle_status})")
    public void save(Vehicle vehicle);
    @Update("update vehicle set vehicle_license_number = #{vehicle_license_number}," +
            "vehicle_type = #{vehicle_type},vehicle_status = #{vehicle_status} " +
            "where vehicle_id = #{vehicle_id}")
    public void update(Vehicle vehicle);
    @Delete("delete from vehicle where vehicle_id = #{vehicle_id}")
    public void delete(Integer vehicle_id);
    @Select("select * from vehicle where vehicle_id = #{vehicle_id}")
    public Vehicle getById(Integer vehicle_id);
    @Select("select * from vehicle")
    public List<Vehicle> getAll();
}
