package com.lsp.controller;

import com.lsp.domain.Driver;
import com.lsp.domain.Employee;
import com.lsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 14:36:17
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Result AddEmployeeInfo(@RequestBody Employee employee) {
        boolean flag = employeeService.AddEmployeeInfo(employee);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result UpdateEmployeeInfo(@RequestBody Employee employee) {
        boolean flag = employeeService.UpdateEmployeeInfo(employee);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{employee_id}")
    public Result DeleteEmployeeInfo(@PathVariable Integer employee_id) {
        boolean flag = employeeService.DeleteEmployeeInfo(employee_id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping
    public Result DisplayEmployeeInfo() {
        List<Employee> employeeList = employeeService.DisplayEmployeeInfo();
        Integer code = employeeList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = employeeList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,employeeList,msg);
    }
}
