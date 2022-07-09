package com.lsp.controller;

import com.lsp.domain.Employee;
import com.lsp.domain.Vehicle;
import com.lsp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 22:25:38
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping
    public Result AddVehicleInfo(@RequestBody Vehicle vehicle){
        boolean flag = vehicleService.AddVehicleInfo(vehicle);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @DeleteMapping("/{vehicle_id}")
    public Result DeleteById(@PathVariable Integer vehicle_id) {
        boolean flag = vehicleService.DeleteById(vehicle_id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @GetMapping("/{vehicle_id}")
    public Result GetById(@PathVariable Integer vehicle_id) {
        Vehicle vehicle = vehicleService.GetById(vehicle_id);
        Integer code = vehicle != null ? Code.GET_OK : Code.GET_ERR;
        String msg = vehicle != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,vehicle,msg);
    }
    @GetMapping
    public Result DisplayVehicleInfo(){
        List<Vehicle> vehicleList = vehicleService.DisplayVehicleInfo();
        Integer code = vehicleList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = vehicleList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,vehicleList,msg);
    }
}
