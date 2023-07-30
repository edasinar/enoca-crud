package com.edasinar.crud.controller;


import com.edasinar.crud.model.Company;
import com.edasinar.crud.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company/list")
    public List<Company> listCompany() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public Company getCompany(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/company")
    public Company saveCompany(@RequestBody Company employee) {
        return companyService.saveCompany(employee);
    }

    @PutMapping("/company/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company employee) {
        return companyService.updateCompany(id, employee);
    }

    @DeleteMapping("/company/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return "Başarılı bir şekilde silindi.";
    }
}
