package Relationship.service;

import Relationship.entity.Company;
import Relationship.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }

    public Company getCompanyById(Long id){
        return companyRepo.findById(id).orElse(null);
    }

    public Company findById(Long id){
        Optional<Company> companyOptional = companyRepo.findById(id);
        return companyOptional.orElse(null);
    }

    public void saveCompany(Company company){
        companyRepo.save(company);
    }

    public void updateCompany(Long id , Company updatedCompany){
        Company company = companyRepo.findById(id).orElse(null);
        company.setCompanyName(updatedCompany.getCompanyName());
        companyRepo.save(company);
    }

    public void deleteCompany(Long id ){
        companyRepo.deleteById(id);
    }
}
