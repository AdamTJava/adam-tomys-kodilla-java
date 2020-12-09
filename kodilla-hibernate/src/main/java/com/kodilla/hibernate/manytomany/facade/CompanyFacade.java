package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    @Autowired
    private CompanyDao companyDao;

    public CompanyFacade(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> searchCompanyByLetters(String letters) {
        return companyDao.retrieveCompaniesWithNameContainsGivenLetters(letters);
    }
}
