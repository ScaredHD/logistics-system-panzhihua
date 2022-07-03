package com.lsp.dao;

import com.lsp.domain.Vehicle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VehicleDao {
    @Insert("insert into vehicle (vehicle_license_number,vehicle_type,vehicle_status) " +
            "values(#{vehicle_license_number},#{vehicle_type},#{vehicle_status})")
    public void save(Vehicle vehicle);
    @Select("select * from vehicle")
    public List<Vehicle> getAll();
}
