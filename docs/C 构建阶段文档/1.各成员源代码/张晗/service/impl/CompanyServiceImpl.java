package com.lsp.service.impl;

import com.lsp.dao.CompanyDao;
import com.lsp.domain.Company;
import com.lsp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 10:12:42
 * @version: 1.0
 * @Description:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    public boolean AddCompanyInfo(Company company) {
        companyDao.save(company);
        return true;
    }

    public boolean UpdateCompanyInfo(Company company) {
        companyDao.update(company);
        return true;
    }

    public boolean DeleteCompanyInfo(Integer company_id) {
        companyDao.delete(company_id);
        return true;
    }

    public List<Company> SearchByCompanyName(String search) {
        return companyDao.GetByName(search);
    }

    public Company GetById(Integer company_id) {
        return companyDao.getById(company_id);
    }

    public List<Company> DisplayCompanyInfo() {
        return companyDao.getAll();
    }
}
