package com.lsp.service;

import com.lsp.domain.Company;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CompanyService {
    public boolean AddCompanyInfo(Company company);
    public boolean UpdateCompanyInfo(Company company);
    public boolean DeleteCompanyInfo(Integer company_id);
    public List<Company> SearchByCompanyName(String search);
    public List<Company> DisplayCompanyInfo();
}
