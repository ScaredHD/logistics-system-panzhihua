package com.lsp.controller;

import com.lsp.domain.Vehicle;
import com.lsp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
