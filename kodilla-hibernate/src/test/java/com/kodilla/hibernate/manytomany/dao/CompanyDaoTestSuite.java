package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testEmployeeNamedQuery() {
        //Given
        Employee adam = new Employee("Adam", "Tomys");
        Employee natalia = new Employee("Natalia", "Tomys");
        Employee marcin = new Employee("Marcin", "Nowak");

        employeeDao.save(adam);
        int adamId = adam.getId();
        employeeDao.save(natalia);
        int nataliaId = natalia.getId();
        employeeDao.save(marcin);
        int marcinId = marcin.getId();

        //When
        List<Employee> employeesWithLastnameTomys = employeeDao.retrieveEmployeesWithLastname("Tomys");

        //Then
        System.out.println(employeesWithLastnameTomys);
        assertEquals(2, employeesWithLastnameTomys.size());

        //Clean up
        employeeDao.deleteById(adamId);
        employeeDao.deleteById(nataliaId);
        employeeDao.deleteById(marcinId);
    }

    @Test
    void testCompanyNamedQuery() {
        //Given
        Company microsoft = new Company("Microsoft");
        Company google = new Company("Google");
        Company dell = new Company("Dell");
        Company toshiba = new Company("Toshiba");

        companyDao.save(microsoft);
        int microsoftId = microsoft.getId();
        companyDao.save(google);
        int googleId = google.getId();
        companyDao.save(dell);
        int dellId = dell.getId();
        companyDao.save(toshiba);
        int toshibaId = toshiba.getId();

        //When
        List<Company> companiesWithNameStartingByMic = companyDao.retrieveCompaniesWithNameDefinedByFirstThreeLetters("Mic");

        //Then
        System.out.println(companiesWithNameStartingByMic);
        assertEquals(1, companiesWithNameStartingByMic.size());

        //Clean up
        companyDao.deleteById(microsoftId);
        companyDao.deleteById(googleId);
        companyDao.deleteById(dellId);
        companyDao.deleteById(toshibaId);
    }
}