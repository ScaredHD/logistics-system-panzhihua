package com.lsp.dao;

import com.lsp.domain.Vehicle;
import org.apache.ibatis.annotations.Insert;

public interface VehicleDao {
    @Insert("insert into vehicle (vehicle_license_number,vehicle_type,vehicle_status) " +
            "values(#{vehicle_license_number},#{vehicle_type},#{vehicle_status})")
    public void save(Vehicle vehicle);
}
