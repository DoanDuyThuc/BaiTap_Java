package com.example.baitap3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/home")
    public String saveUser(@ModelAttribute UserModel userModel) {
        userService.saveOrUpdate(userModel);
        return "redirect:/home";
    }
    
    @GetMapping("/home/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userDetail";
    }
}
