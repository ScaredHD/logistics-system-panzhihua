package com.lsp.service.impl;

import com.lsp.dao.VehicleDao;
import com.lsp.domain.Vehicle;
import com.lsp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 22:11:48
 * @version: 1.0
 * @Description:
 */
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    public boolean AddVehicleInfo(Vehicle vehicle) {
        vehicleDao.save(vehicle);
        return true;
    }

    public Vehicle GetById(Integer vehicle_id) {
        return vehicleDao.getById(vehicle_id);
    }

    public boolean DeleteById(Integer vehicle_id) {
        vehicleDao.delete(vehicle_id);
        return true;
    }

    public List<Vehicle> DisplayVehicleInfo() {
        return vehicleDao.getAll();
    }
}
