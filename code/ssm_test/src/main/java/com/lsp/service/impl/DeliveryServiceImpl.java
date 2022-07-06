package com.lsp.service.impl;

import com.lsp.dao.DeliveryDao;
import com.lsp.dao.DriverDao;
import com.lsp.dao.VehicleDao;
import com.lsp.domain.Delivery;
import com.lsp.domain.Driver;
import com.lsp.domain.Vehicle;
import com.lsp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月06日 14:22:57
 * @version:
 * @Description:
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;
    @Autowired
    private DriverDao driverDao;
    @Autowired
    private VehicleDao vehicleDao;
    public boolean AddDeliveryInfo(Delivery delivery) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        delivery.setDeliver_status('0');
        delivery.setDeliver_time(timestamp);
        Driver driver = driverDao.getById(delivery.getD_driver_id());
        driver.setDriver_status('0');
        Vehicle vehicle = vehicleDao.getById(delivery.getD_vehicle_id());
        vehicle.setVehicle_status('0');
        driverDao.update(driver);
        vehicleDao.update(vehicle);
        deliveryDao.save(delivery);
        return true;
    }

    public boolean UpdateDeliveryInfo(Delivery delivery) {
        if(delivery.getDeliver_status()=='1'){
            Driver driver = driverDao.getById(delivery.getD_driver_id());
            driver.setDriver_status('1');
            Vehicle vehicle = vehicleDao.getById(delivery.getD_vehicle_id());
            vehicle.setVehicle_status('1');
            driverDao.update(driver);
            vehicleDao.update(vehicle);
        }
        deliveryDao.update(delivery);
        return true;
    }

    public List<Delivery> DisplayDeliveryInfo() {
        return deliveryDao.getAll();
    }
}
