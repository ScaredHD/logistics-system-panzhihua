package com.lsp.service.impl;

import com.lsp.dao.EmployeeDao;
import com.lsp.domain.Employee;
import com.lsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月03日 14:21:28
 * @version: 1.0
 * @Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    public boolean AddEmployeeInfo(Employee employee) {
        employeeDao.save(employee);
        return true;
    }

    public boolean UpdateEmployeeInfo(Employee employee) {
        employeeDao.update(employee);
        return true;
    }

    public boolean DeleteEmployeeInfo(Integer employee_id) {
        employeeDao.delete(employee_id);
        return true;
    }

    public Employee GetById(Integer employee_id) {
        return employeeDao.getById(employee_id);
    }

    public List<Employee> DisplayEmployeeInfo() {
        return employeeDao.getAll();
    }
}
