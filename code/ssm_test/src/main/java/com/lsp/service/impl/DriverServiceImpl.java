package com.lsp.service.impl;

import com.lsp.dao.DriverDao;
import com.lsp.domain.Driver;
import com.lsp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 11:39:10
 * @version: 1.0
 * @Description:
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverDao driverDao;
    public boolean AddDriverInfo(Driver driver) {
        driverDao.save(driver);
        return true;
    }

    public boolean UpdateDriverInfo(Driver driver) {
        driverDao.update(driver);
        return true;
    }

    public boolean DeleteDriverInfo(Integer driver_id) {
        driverDao.delete(driver_id);
        return true;
    }


    public List<Driver> DisplayDriverInfo() {
        return driverDao.getAll();
    }
}
