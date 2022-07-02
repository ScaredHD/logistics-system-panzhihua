package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 10:12:18
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/companys")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping
    public boolean AddCompanyInfo(@RequestBody Company company) {
        return companyService.AddCompanyInfo(company);
    }
    @PutMapping
    public boolean UpdateCompanyInfo(@RequestBody Company company) {
        return companyService.UpdateCompanyInfo(company);
    }
    @DeleteMapping("/{company_id}")
    public boolean DeleteCompanyInfo(@PathVariable Integer company_id) {
        return companyService.DeleteCompanyInfo(company_id);
    }
    @GetMapping("/{search}")
    public List<Company> SearchByCompanyName(@PathVariable String search) {
        return companyService.SearchByCompanyName(search);
    }
    @GetMapping
    public List<Company> DisplayCompanyInfo() {
        return companyService.DisplayCompanyInfo();
    }
}
