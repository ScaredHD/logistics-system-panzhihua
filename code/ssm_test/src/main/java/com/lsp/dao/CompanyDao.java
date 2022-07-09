package com.lsp.dao;

import com.lsp.domain.Company;
import com.lsp.domain.Driver;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface CompanyDao {
    @Insert("insert into company (company_name,company_tel,company_contacts,company_isvisible) " +
            "values(#{company_name},#{company_tel},#{company_contacts},company_isvisible)")
    public void save(Company company);
    @Update("update company set company_name = #{company_name},company_tel = #{company_tel},company_contacts = #{company_contacts}," +
            "company_isvisible = #{company_isvisible} where company_id = #{company_id}")
    public void update(Company company);
    @Update("update company set company_isvisible = '0' where company_id = #{company_id}")
    public void delete(Integer company_id);
    @Select("select company_id,company_name,company_tel,company_contacts from company " +
            "where company_name like concat('%',#{search},'%')")
    public List<Company> GetByName(String search);
    @Select("select * from company where company_id = #{company_id} and company_isvisible = '1'")
    public Company getById(Integer company_id);
    @Select("select * from company where company_isvisible = '1'")
    public List<Company> getAll();
}
