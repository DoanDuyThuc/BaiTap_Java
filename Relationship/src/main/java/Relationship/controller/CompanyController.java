package Relationship.controller;

import Relationship.entity.Company;
import Relationship.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/savecompany")
    public String addCompany(Model model){
        model.addAttribute("company" , new Company());
        return "addcompany";
    }

    @GetMapping("/getallcompany")
    public String getAllCompany(Model model){
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyList" , companyList);
        return "getallcompany";
    }

    @PostMapping("/savecompany")
    public String addCompany(@ModelAttribute("company")Company company){
        companyService.saveCompany(company);
        return "redirect:/getallcompany";
    }

    @GetMapping("/updatecompany/{id}")
    public String updateCompany(@PathVariable("id") Long id , Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company" , company);
        return "updatecompany";
    }

    @PostMapping("/updatecompany/{id}")
    public String updateCompany(@PathVariable("id") Long id ,@ModelAttribute Company company){
        companyService.updateCompany(id , company);
        return "redirect:/getallcompany";
    }

    @GetMapping("/deletecompany/{id}")
    public String deleteCompany(@PathVariable("id") Long id){
        companyService.deleteCompany(id);
        return "redirect:/getallcompany";
    }
}
