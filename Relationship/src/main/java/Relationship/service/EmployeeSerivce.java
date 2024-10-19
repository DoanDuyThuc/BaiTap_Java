package Relationship.service;

import Relationship.entity.Company;
import Relationship.entity.Employee;
import Relationship.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeSerivce {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CompanyService companyService;

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        Set<Company> companies = new HashSet<>();
        for(Company company : employee.getCompanies()){
            Company foundCpmpany = companyService.findById(company.getId());
            if(foundCpmpany != null){
                companies.add(foundCpmpany);
            }
        }
        employee.setCompanies(companies);
        employee.setCompanyName(companies.iterator().next().getCompanyName());
        return employeeRepo.save(employee);
    }

    public void updateEmployee(Long id , Employee updateEmployee){
        Employee employees = employeeRepo.findById(id).orElse(null);
        employees.setUsername(updateEmployee.getUsername());
        employees.setEmail(updateEmployee.getEmail());
        employees.setNumberphone(updateEmployee.getNumberphone());
        Set<Company> updatedCompanies = new HashSet<>();
        for (Company company : updateEmployee.getCompanies()) {
            Company foundCompany = companyService.findById(company.getId());
            if (foundCompany != null) {
                updatedCompanies.add(foundCompany);
            }
        }
        employees.setCompanies(updatedCompanies);
        employeeRepo.save(employees);
    }


    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

}
