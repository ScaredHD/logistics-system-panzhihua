package com.lsp.service;

import com.lsp.domain.Driver;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DriverService {
    public boolean AddDriverInfo(Driver driver);
    public boolean UpdateDriverInfo(Driver driver);
    public boolean DeleteDriverInfo(Integer driver_id);
    public List<Driver> DisplayDriverInfo();
}
