package com.lsp.dao;

import com.lsp.domain.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface CompanyDao {
    @Insert("insert into company (company_name,company_tel,company_contacts) values(#{company_name},#{company_tel},#{company_contacts})")
    public void save(Company company);
    @Update("update company set company_name = #{company_name},company_tel = #{company_tel},company_contacts = #{company_contacts} " +
            "where company_id = #{company_id}")
    public void update(Company company);
    @Delete("delete from company where company_id = #{company_id}")
    public void delete(Integer company_id);
    @Select("select company_name,company_tel,company_contacts from company " +
            "where company_name like concat('%',#{search},'%')")
    public List<Company> GetByName(String search);
    @Select("select * from company")
    public List<Company> getAll();
}
