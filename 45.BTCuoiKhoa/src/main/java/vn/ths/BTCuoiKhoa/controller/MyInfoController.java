package vn.ths.BTCuoiKhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.ths.BTCuoiKhoa.dao.EmployeeRepository;
import vn.ths.BTCuoiKhoa.dao.StudentRepository;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

@Controller
@RequestMapping("/myInfo")
public class MyInfoController {
    private MyService<Student> studentMyService;
    private MyService<School> schoolMyService;
    private MyService<ClassRoom> classRoomMyService;
    private MyService<Employee> employeeMyService;
    private MyService<Parent> parentMyService;
    private MyService<ReportCard> reportCardMyService;
    private MyService<Role> roleMyService;
    private MyService<Account> accountMyService;
    private MyService<SchoolProfile> schoolProfileMyService;
    private MyService<StarterBook> starterBookMyService;
    private MyService<StudentCard> service;
    private MyService<Subject> subjectMyService;
    private MyService<Transcript> transcriptMyService;
    private EmployeeRepository employeeRepository;
    private StudentRepository studentRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public MyInfoController(MyService<Student> studentMyService, MyService<School> schoolMyService, MyService<ClassRoom> classRoomMyService, MyService<Employee> employeeMyService, MyService<Parent> parentMyService, MyService<ReportCard> reportCardMyService, MyService<Role> roleMyService, MyService<Account> accountMyService, MyService<SchoolProfile> schoolProfileMyService, MyService<StarterBook> starterBookMyService, MyService<StudentCard> service, MyService<Subject> subjectMyService, MyService<Transcript> transcriptMyService, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        this.studentMyService = studentMyService;
        this.schoolMyService = schoolMyService;
        this.classRoomMyService = classRoomMyService;
        this.employeeMyService = employeeMyService;
        this.parentMyService = parentMyService;
        this.reportCardMyService = reportCardMyService;
        this.roleMyService = roleMyService;
        this.accountMyService = accountMyService;
        this.schoolProfileMyService = schoolProfileMyService;
        this.starterBookMyService = starterBookMyService;
        this.service = service;
        this.subjectMyService = subjectMyService;
        this.transcriptMyService = transcriptMyService;
        this.employeeRepository = employeeRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/teacher")
    public String getInfoTeacher(Model model){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        model.addAttribute("employee",employee);
        return "/info/teacher-my-info";
    }

    @GetMapping("/student")
    public String getInfoStudent(Model model){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountMyService.findByName(userName);
        Student student = studentRepository.findByAccount(account);
        StudentCard studentCard = service.findByName(student.getLastName());
        model.addAttribute("studentCard",studentCard);
        return "/info/student-my-info";
    }
}
