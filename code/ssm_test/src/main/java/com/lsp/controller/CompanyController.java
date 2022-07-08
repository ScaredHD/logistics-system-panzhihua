package com.lsp.controller;

import com.lsp.domain.Company;
import com.lsp.domain.Driver;
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
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping
    public Result AddCompanyInfo(@RequestBody Company company) {
        boolean flag = companyService.AddCompanyInfo(company);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result UpdateCompanyInfo(@RequestBody Company company) {
        boolean flag = companyService.UpdateCompanyInfo(company);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{company_id}")
    public Result DeleteCompanyInfo(@PathVariable Integer company_id) {
        boolean flag = companyService.DeleteCompanyInfo(company_id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @GetMapping("/{search}")
    public Result SearchByCompanyName(@PathVariable String search) {
        List<Company> companyList = companyService.SearchByCompanyName(search);
        Integer code = companyList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = companyList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,companyList,msg);
    }
//    @GetMapping("/{company_id}")
//    public Result GetById(@PathVariable Integer company_id) {
//        Company company = companyService.GetById(company_id);
//        Integer code = company != null ? Code.GET_OK : Code.GET_ERR;
//        String msg = company != null ? "":"GET ERROR:PLEASE RETRY!";
//        return new Result(code,company_id,msg);
//    }
    @GetMapping
    public Result DisplayCompanyInfo() {
        List<Company> companyList = companyService.DisplayCompanyInfo();
        Integer code = companyList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = companyList != null ? "":"GET ERROR:PLEASE RETRY!";
        return new Result(code,companyList,msg);
    }
}
