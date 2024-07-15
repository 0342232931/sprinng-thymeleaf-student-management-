package vn.ths.BTCuoiKhoa.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.ths.BTCuoiKhoa.dao.AccountRepository;
import vn.ths.BTCuoiKhoa.dao.EmployeeRepository;
import vn.ths.BTCuoiKhoa.dao.StudentRepository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.Student;

@Controller
public class HomeController {

    private AccountRepository accountRepository;
    private EmployeeRepository employeeRepository;
    private StudentRepository studentRepository;

    @Autowired
    public HomeController(AccountRepository accountRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping("/home")
    public String returnHome(Model model){
        return "home";
    }

    @GetMapping("/news")
    public String returnNews(){
        return "news";
    }

    @GetMapping("/showLoginPage")
    public String loginform(){
        return "login";
    }

    @GetMapping("/contact")
    public String returncontact(){
        return "contact";
    }
}
