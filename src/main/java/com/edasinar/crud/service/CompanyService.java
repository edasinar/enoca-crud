package com.edasinar.crud.service;

import com.edasinar.crud.model.Company;
import com.edasinar.crud.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company saveCompany(Company comp) {
        return companyRepository.save(comp);
    }

    public Company updateCompany(Long id, Company comp) {
        Company currentComp = getCompanyById(id);
        if (currentComp == null || comp == null) {
            return null;
        }

        if (comp.getName() != null) {
            currentComp.setName(comp.getName());
        }

        return saveCompany(currentComp);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
