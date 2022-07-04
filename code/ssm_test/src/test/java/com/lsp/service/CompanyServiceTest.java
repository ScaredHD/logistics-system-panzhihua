package com.lsp.service;

import com.lsp.config.SpringConfig;
import com.lsp.config.SpringMvcConfig;
import com.lsp.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月02日 11:06:23
 * @version: 1.0
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CompanyServiceTest {
    @Autowired
    private  CompanyService companyService;
    @Test
    public void testSearchByCompanyName(){
        List<Company> company = companyService.SearchByCompanyName("京东");
        System.out.println(company);
    }
    @Test
    public void testDisplayCompanyInfo(){
        List<Company> company = companyService.DisplayCompanyInfo();
        System.out.println(company);
    }
//    @Test
//    public void testUser(){
//        System.out.println();
//    }
}
