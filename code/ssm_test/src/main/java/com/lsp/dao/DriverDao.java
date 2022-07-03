package com.lsp.dao;

import com.lsp.domain.Driver;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DriverDao {
    @Insert("insert into driver (driver_name,driver_gender,driver_tel,driver_license,driver_id_card," +
            "driver_license_score,driver_address,driver_status) values(#{driver_name},#{driver_gender},#{driver_tel}," +
            "#{driver_license},#{driver_id_card},#{driver_license_score},#{driver_address},#{driver_status})")
    public void save(Driver driver);
    @Update("update driver set driver_name = #{driver_name},driver_gender = #{driver_gender}," +
            "driver_tel = #{driver_tel},driver_license = #{driver_license},driver_id_card = #{driver_id_card}," +
            "driver_license_score = #{driver_license_score},driver_address = #{driver_address},driver_status = #{driver_status} " +
            "where driver_id = #{driver_id}")
    public void update(Driver driver);
    @Delete("delete from driver where driver_id = #{driver_id}")
    public void delete(Integer driver_id);
    @Select("select * from driver")
    public List<Driver> getAll();
}
