package com.lsp.domain;

/**
 * @Author:
 * @createTime: 2022年07月02日 10:09:44
 * @version: 1.0
 * @Description:
 */
public class Company {
    private Integer company_id;
    private String company_name;
    private String company_tel;
    private String company_contacts;

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", company_tel='" + company_tel + '\'' +
                ", company_contacts='" + company_contacts + '\'' +
                '}';
    }
    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_tel() {
        return company_tel;
    }

    public void setCompany_tel(String company_tel) {
        this.company_tel = company_tel;
    }

    public String getCompany_contacts() {
        return company_contacts;
    }

    public void setCompany_contacts(String company_contacts) {
        this.company_contacts = company_contacts;
    }

}
