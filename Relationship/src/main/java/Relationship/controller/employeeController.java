package Relationship.controller;

import Relationship.entity.Employee;
import Relationship.service.CompanyService;
import Relationship.service.EmployeeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class employeeController {
    @Autowired
    private EmployeeSerivce employeeSerivce;

    @Autowired
    private CompanyService companyService;


    @GetMapping("/addemployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("companyList", companyService.getAllCompany());
        return "addemployee";
}


    @GetMapping("/getemployee")
    public String getEmployee(Model model){
        List<Employee> employees = employeeSerivce.getAllEmployee();
        model.addAttribute("employees" , employees);
        return "employee";
    }

    @GetMapping("/getemployee/{id}")
    public String getEmployeeById(@PathVariable("id") Long id , Model model){
        Employee employee = employeeSerivce.getEmployeeById(id);
        model.addAttribute("employee" , employee);
        return "employee-detail";
    }

    @PostMapping("/addemployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeSerivce.saveEmployee(employee);
        return "redirect:/getemployee";
    }

    @GetMapping("/updateemployee/{id}")
    public String formUpdateEmploy(@PathVariable("id") Long id , Model model){
        Employee employee = employeeSerivce.getEmployeeById(id);
        model.addAttribute("employee" , employee);
        return "updateemployee";
    }

    @PostMapping("/updateemployee/{id}")
    public String updateEmployee(@PathVariable("id") Long id , @ModelAttribute Employee employee){
        employeeSerivce.updateEmployee(id , employee);
        return "redirect:/getemployee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeSerivce.deleteEmployee(id);
        return "redirect:/getemployee";
    }
}
