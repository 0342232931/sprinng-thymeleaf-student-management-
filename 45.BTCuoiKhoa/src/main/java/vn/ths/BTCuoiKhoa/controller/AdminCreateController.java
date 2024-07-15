package vn.ths.BTCuoiKhoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.ths.BTCuoiKhoa.entity.*;

@Controller
@RequestMapping(value = "/create")
public class AdminCreateController {

    @GetMapping("/createStudent")
    public String Save1(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "/admincreate/student-create";
    }

    @GetMapping("/createAccount")
    public String Save2(Model model){
        Account account = new Account();
        model.addAttribute("account",account);
        return "/admincreate/account-create";
    }

    @GetMapping("/createEmployee")
    public String Save3(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "/admincreate/employee-create";
    }

    @GetMapping("/createParent")
    public String Save4(Model model){
        Parent parent = new Parent();
        model.addAttribute("parent",parent);
        return "/admincreate/parent-create";
    }

    @GetMapping("/createReportCard")
    public String Save5(Model model){
        ReportCard reportCard = new ReportCard();
        model.addAttribute("reportCard",reportCard);
        return "/admincreate/reportcard-create";
    }

    @GetMapping("/createRole")
    public String Save6(Model model){
        Role role = new Role();
        model.addAttribute("role_role",role);
        return "/admincreate/role-create";
    }

    @GetMapping("/createSchool")
    public String Save7(Model model){
        School school = new School();
        model.addAttribute("school",school);
        return "/admincreate/school-create";
    }

    @GetMapping("/createSchoolProfile")
    public String Save8(Model model){
        SchoolProfile schoolProfile = new SchoolProfile();
        model.addAttribute("schoolProfile",schoolProfile);
        return "/admincreate/schoolprofile-create";
    }

    @GetMapping("/createStarterBook")
    public String Save9(Model model){
        StarterBook starterBook = new StarterBook();
        model.addAttribute("starterBook",starterBook);
        return "/admincreate/starterbook-create";
    }

    @GetMapping("/createStudentCard")
    public String Save10(Model model){
        StudentCard studentCard = new StudentCard();
        model.addAttribute("studentCard",studentCard);
        return "/admincreate/studentcard-create";
    }

    @GetMapping("/createSubject")
    public String Save11(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject",subject);
        return "/admincreate/subject-create";
    }

    @GetMapping("/createTranscript")
    public String Save12(Model model){
        Transcript transcript = new Transcript();
        model.addAttribute("transcript",transcript);
        return "/admincreate/transcript-create";
    }

    @GetMapping("/createClassRoom")
    public String save13(Model model){
        ClassRoom classRoom = new ClassRoom();
        model.addAttribute("classRoom",classRoom);
        return "/admincreate/classroom-create";
    }
}
