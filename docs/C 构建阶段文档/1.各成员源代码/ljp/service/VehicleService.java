package com.lsp.service;

import com.lsp.domain.Vehicle;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface VehicleService {
    public boolean AddVehicleInfo(Vehicle vehicle);
    public Vehicle GetById(Integer vehicle_id);
    public List<Vehicle> DisplayVehicleInfo();
}
