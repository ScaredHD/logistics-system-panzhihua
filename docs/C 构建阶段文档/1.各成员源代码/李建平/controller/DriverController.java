package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Driver;
import com.lsp.domain.Employee;
import com.lsp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 11:42:12
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping
    public Result AddDriverInfo(@RequestBody Driver driver) {
        boolean flag = driverService.AddDriverInfo(driver);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result UpdateDriverInfo(@RequestBody Driver driver) {
        boolean flag = driverService.UpdateDriverInfo(driver);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{driver_id}")
    public Result DeleteDriverInfo(@PathVariable Integer driver_id) {
        boolean flag = driverService.DeleteDriverInfo(driver_id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @GetMapping("/{driver_id}")
    public Result GetById(@PathVariable Integer driver_id) {
        Driver driver = driverService.GetById(driver_id);
        Integer code = driver != null ? Code.GET_OK : Code.GET_ERR;
        String msg = driver != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,driver,msg);
    }
    @GetMapping
    public Result DisplayDriverInfo() {
        List<Driver> driverList = driverService.DisplayDriverInfo();
        Integer code = driverList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = driverList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,driverList,msg);
    }
}
