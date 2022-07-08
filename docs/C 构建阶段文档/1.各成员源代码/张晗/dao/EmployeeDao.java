package com.lsp.dao;

import com.lsp.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeDao {
    @Insert("insert into employee (employee_name,employee_gender,employee_id_card,employee_tel,employee_address) " +
            "values(#{employee_name},#{employee_gender},#{employee_id_card},#{employee_tel},#{employee_address})")
    public void save(Employee employee);
    @Update("update employee set employee_name = #{employee_name},employee_gender = #{employee_gender}," +
            "employee_id_card = #{employee_id_card},employee_tel = #{employee_tel},employee_address = #{employee_address}," +
            "where employee_id = #{employee_id}")
    public void update(Employee employee);
    @Delete("delete from employee where employee_id = #{employee_id}")
    public void delete(Integer employee_id);
    @Select("select * from employee where employee_id = #{employee_id}")
    public Employee getById(Integer employee_id);
    @Select("select * from employee")
    public List<Employee> getAll();
}
