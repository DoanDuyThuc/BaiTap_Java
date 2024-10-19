package baitap2.baitap2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @GetMapping("/user")
    public String getUsername(Model model){
        model.addAttribute("username", "Nguyễn Văn An");
        return "user";
    }

    @GetMapping("/adduser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/addUser")
    public void saveUser(@ModelAttribute("user") User user){
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("idSinhVien: " + user.getIdSinhvien());
        System.out.println("SoCCCD: " + user.getSoCCCD());
        System.out.println("NgayThangNamSinh: " + user.getNgayThangNamSinh());
    }
}
