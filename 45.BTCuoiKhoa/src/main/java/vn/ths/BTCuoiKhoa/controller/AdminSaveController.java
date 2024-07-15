package vn.ths.BTCuoiKhoa.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.ths.BTCuoiKhoa.dao.RoleRepository;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

import javax.imageio.ImageIO;
import javax.sql.DataSource;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/save")
public class AdminSaveController {
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
    private RoleRepository roleRepository;
    private DataSource dataSource;

    @Autowired
    public AdminSaveController(MyService<Student> studentMyService, MyService<School> schoolMyService, MyService<ClassRoom> classRoomMyService, MyService<Employee> employeeMyService, MyService<Parent> parentMyService, MyService<ReportCard> reportCardMyService, MyService<Role> roleMyService, MyService<Account> accountMyService, MyService<SchoolProfile> schoolProfileMyService, MyService<StarterBook> starterBookMyService, MyService<StudentCard> service, MyService<Subject> subjectMyService, MyService<Transcript> transcriptMyService, RoleRepository roleRepository, DataSource dataSource) {
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
        this.roleRepository = roleRepository;
        this.dataSource = dataSource;
    }

    @PostMapping("/student")
    public String save1(@ModelAttribute("student") Student student, @RequestParam("account_id") int id_account,@RequestParam("class_id") int id_class,@RequestParam("parent_id") int id_parent){
        Account account = accountMyService.getById(id_account);
        ClassRoom classRoom = classRoomMyService.getById(id_class);
        Parent parent = parentMyService.getById(id_parent);
        student.setAccount(account);
        student.setClassRoom(classRoom);
        student.setParent(parent);
        studentMyService.add(student);
        return "redirect:/create/createStudent";
    }


    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @PostMapping("/account")
    public String save2(@Valid @ModelAttribute("account") Account account, BindingResult result,
                        Model model, @RequestParam("roleName") String roleName, HttpSession session){
        Role role = roleRepository.findRoleByRole(roleName);
        List<Role> r = new ArrayList<>();
        r.add(role);

        if(result.hasErrors()){
            return "admincreate/account-create";
        }
        Account accountExiting = accountMyService.findByName(account.getUserName());
        if(accountExiting != null){
            model.addAttribute("account", new Account());
            model.addAttribute("Error" , "Tài khoản này đã tồn tại!");
            return "admincreate/account-create";
        }

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Account account1 = new Account();
        account1.setUserName(account.getUserName());
        account1.setPassword(bcrypt.encode(account.getPassword()));
        account1.setActive(account.isActive());
        account1.setRole(r);
        accountMyService.add(account1);
        return "redirect:/create/createAccount";
    }



    @PostMapping("/classRoom")
    public String save3(@ModelAttribute("classRoom") ClassRoom classRoom, @RequestParam("school_id") int school_id, @RequestParam("employee_id") int employee_id){
        School school = schoolMyService.getById(school_id);
        Employee employee = employeeMyService.getById(employee_id);
        classRoom.setEmployee(employee);
        classRoom.setSchool(school);
        classRoomMyService.add(classRoom);
        return "redirect:/create/createClassRoom";
    }

    @PostMapping("/employee")
    public String save4(@ModelAttribute("employee") Employee employee, @RequestParam("account_id") int account_id, @RequestParam("photo") MultipartFile photo,Model model){
        Account account = accountMyService.getById(account_id);
        employee.setAccount(account);
        employee.setAvatar(null);
        try {
            byte[] imageByteArray = photo.getBytes();
            try {
                Connection connection = dataSource.getConnection();
                Blob avatar = connection.createBlob();
                avatar.setBytes(1,imageByteArray);
                employee.setAvatar(avatar);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            model.addAttribute("Error", "Lỗi khi lưu ảnh: " + e.getMessage());
            return "redirect:/create/createEmployee";
        }

        employeeMyService.add(employee);
        return "redirect:/create/createEmployee";
    }

    @PostMapping("/parent")
    public String save5(@ModelAttribute("parent") Parent parent, @RequestParam("account_id") int account_id, @RequestParam("photo") MultipartFile photo, Model model){
        Account account = accountMyService.getById(account_id);
        parent.setAccount(account);
        parent.setAvatar(null);
        try {
            byte[] imageByteArray = photo.getBytes();
            try {
                Connection connection = dataSource.getConnection();
                Blob avatar = connection.createBlob();
                avatar.setBytes(1,imageByteArray);
                parent.setAvatar(avatar);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            model.addAttribute("Error", "Lỗi khi lưu ảnh: " + e.getMessage());
            return "redirect:/create/createEmployee";
        }
        parentMyService.add(parent);
        return "redirect:/create/createParent";
    }

    @PostMapping("/reportCard")
    public String save6(@ModelAttribute("reportCard") ReportCard reportCard, @RequestParam("student_id") int student_id, @RequestParam("subject_id") int subject_id){
        Student student = studentMyService.getById(student_id);
        Subject subject = subjectMyService.getById(subject_id);
        reportCard.setSubject(subject);
        reportCard.setStudent(student);
        reportCardMyService.add(reportCard);
        return "redirect:/create/createReportCard";
    }

    @PostMapping("/role")
    public String save7(@ModelAttribute("role_role") Role role){
        roleMyService.add(role);
        //role.getRole().toString();
        return "redirect:/create/createRole";
    }

    @PostMapping("/schoolProfile")
    public String save8(@ModelAttribute("schoolProfile") SchoolProfile schoolProfile, @RequestParam("student_id") int student_id){
        Student student = studentMyService.getById(student_id);
        schoolProfile.setStudent(student);
        schoolProfileMyService.add(schoolProfile);
        return "redirect:/create/createSchoolProfile";
    }

    @PostMapping("/school")
    public String save9(@ModelAttribute("school") School school){
        schoolMyService.add(school);
        return "redirect:/create/createSchool";
    }

    @PostMapping("/starterBook")
    public String save10(@ModelAttribute("starterBook") StarterBook starterBook, @RequestParam("class_id") int class_id, @RequestParam("employee_id") int employee_id){
        ClassRoom classRoom = classRoomMyService.getById(class_id);
        Employee employee = employeeMyService.getById(employee_id);
        starterBook.setClassRoom(classRoom);
        starterBook.setEmployee(employee);
        starterBookMyService.add(starterBook);
        return "redirect:/create/createStarterBook";
    }

    @PostMapping("/studentCard")
    public String save111(@ModelAttribute("studentCard") StudentCard studentCard, @RequestParam("student_id") int student_id, @RequestParam("photo") MultipartFile photo, Model model) throws IOException {
        Student student = studentMyService.getById(student_id);
        studentCard.setStudent(student);
        studentCard.setAvatar(null);
        try {
            byte[] imageByteArray = photo.getBytes();
            try {
                Connection connection = dataSource.getConnection();
                Blob avatar = connection.createBlob();
                avatar.setBytes(1,imageByteArray);
                studentCard.setAvatar(avatar);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            model.addAttribute("Error", "Lỗi khi lưu ảnh: " + e.getMessage());
            return "redirect:/create/createEmployee";
        }
        service.add(studentCard);
        return "redirect:/create/createStudentCard";
    }

    @PostMapping("/subject")
    public String save12(@ModelAttribute("subject") Subject subject, @RequestParam("employee_id") int employee_id){
        Employee employee = employeeMyService.getById(employee_id);
        subject.setEmployee(employee);
        subjectMyService.add(subject);
        return "redirect:/create/createSubject";
    }

    @PostMapping("/transcript")
    public String save13(@ModelAttribute("transcript") Transcript transcript, @RequestParam("student_id") int student_id, @RequestParam("subject_id") int subject_id){
        Student student = studentMyService.getById(student_id);
        Subject subject = subjectMyService.getById(subject_id);
        transcript.setStudent(student);
        transcript.setSubject(subject);
        transcriptMyService.add(transcript);
        return "redirect:/create/createTranscript";
    }
}