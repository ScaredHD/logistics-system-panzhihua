package com.lsp.service;

import com.lsp.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeService {
    public boolean AddEmployeeInfo(Employee employee);
    public boolean UpdateEmployeeInfo(Employee employee);
    public boolean DeleteEmployeeInfo(Integer employee_id);
    public List<Employee> DisplayEmployeeInfo();
}
