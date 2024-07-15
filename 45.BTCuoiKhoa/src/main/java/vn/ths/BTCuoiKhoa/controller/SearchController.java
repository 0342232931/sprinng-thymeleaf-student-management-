package vn.ths.BTCuoiKhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import vn.ths.BTCuoiKhoa.dao.*;
import vn.ths.BTCuoiKhoa.entity.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@Controller
@RequestMapping("/search")
public class SearchController {
    private AccountRepository accountRepository;
    private ClassRoomRepository classRoomRepository;
    private EmployeeRepository employeeRepository;
    private ParentRepository parentRepository;
    private ReportCardRepository reportCardRepository;
    private RoleRepository roleRepository;
    private SchoolRepository schoolRepository;
    private SchoolProfileRepository schoolProfileRepository;
    private StarterBookRepository starterBookRepository;
    private StudentRepository studentRepository;
    private StudentCardRepository studentCardRepository;
    private SubjectRepository subjectRepository;
    private TranscriptRepository transcriptRepository;

    @Autowired
    public SearchController(AccountRepository accountRepository, ClassRoomRepository classRoomRepository, EmployeeRepository employeeRepository, ParentRepository parentRepository, ReportCardRepository reportCardRepository, RoleRepository roleRepository, SchoolRepository schoolRepository, SchoolProfileRepository schoolProfileRepository, StarterBookRepository starterBookRepository, StudentRepository studentRepository, StudentCardRepository studentCardRepository, SubjectRepository subjectRepository, TranscriptRepository transcriptRepository) {
        this.accountRepository = accountRepository;
        this.classRoomRepository = classRoomRepository;
        this.employeeRepository = employeeRepository;
        this.parentRepository = parentRepository;
        this.reportCardRepository = reportCardRepository;
        this.roleRepository = roleRepository;
        this.schoolRepository = schoolRepository;
        this.schoolProfileRepository = schoolProfileRepository;
        this.starterBookRepository = starterBookRepository;
        this.studentRepository = studentRepository;
        this.studentCardRepository = studentCardRepository;
        this.subjectRepository = subjectRepository;
        this.transcriptRepository = transcriptRepository;
    }

    @GetMapping("/account")
    public String search1(@RequestParam("accountName") String accountName, Model model){
        Account account = accountRepository.findByUserName(accountName);
        model.addAttribute("account",account);
        return "/adminview/account-info";
    }

    @GetMapping("/class")
    public String search2(@RequestParam("className") String className, Model model){
        ClassRoom classRoom = classRoomRepository.findByClassName(className);
        model.addAttribute("class",classRoom);
        return "/adminview/class-info";
    }

    @GetMapping("/employee")
    public String search3(@RequestParam("employeeName") String employeeName, Model model){
        Employee employee = employeeRepository.findByLastName(employeeName);
        model.addAttribute("employee",employee);
        return "/adminview/employee-info";
    }

    @GetMapping("/parent")
    public String search4(@RequestParam("parentName") String parentName, Model model){
        Parent parent = parentRepository.findByLastName(parentName);
        model.addAttribute("parent",parent);
        return "/adminview/parent-info";
    }

    @GetMapping("/reportCard")
    public String search5(@RequestParam("title") String title, Model model){
        ReportCard reportCard = reportCardRepository.findByTitle(title);
        model.addAttribute("reportCard",reportCard);
        return "/adminview/account-info";
    }

    @GetMapping("/role")
    public String search6(@RequestParam("roleName") String roleName, Model model){
        Role role = roleRepository.findRoleByRole(roleName);
        model.addAttribute("role",role);
        return "/adminview/role-info";
    }

    @GetMapping("/school")
    public String search7(@RequestParam("schoolName") String schoolName, Model model){
        School school = schoolRepository.findBySchoolName(schoolName);
        model.addAttribute("school",school);
        return "/adminview/school-info";
    }

    @GetMapping("/schoolProfile")
    public String search8(@RequestParam("studentLastName") String studentLastName, Model model){
        Student student = studentRepository.findByLastName(studentLastName);
        SchoolProfile schoolProfile = schoolProfileRepository.findByStudent(student);
        model.addAttribute("schoolProfile",schoolProfile);
        return "/adminview/schoolProfile-info";
    }

    @GetMapping("/starterBook")
    public String search9(@RequestParam("date") Date date, Model model){
        StarterBook starterBook = starterBookRepository.findByTeachingDay(date);
        model.addAttribute("starterBook",starterBook);
        return "/adminview/starterBook-info";
    }

    @GetMapping("/student")
    public String search10(@RequestParam("lastName") String lastName, Model model){
        Student student = studentRepository.findByLastName(lastName);
        model.addAttribute("student",student);
        return "/adminview/student-info";
    }

    @GetMapping("/studentCard")
    public String search11(@RequestParam("lastName") String lastName, Model model){
        StudentCard studentCard = studentCardRepository.findByLastName(lastName);
        model.addAttribute("studentCard",studentCard);
        return "/adminview/studentCard-info";
    }

    @GetMapping("/subject")
    public String search12(@RequestParam("subjectCode") String subjectCode, Model model){
        Subject subject = subjectRepository.findBySubjectCode(subjectCode);
        model.addAttribute("subject",subject);
        return "/adminview/subject-info";
    }

    @GetMapping("/transcript")
    public String search13(@RequestParam("subjectCode") String subjectCode, Model model){
        Subject subject = subjectRepository.findBySubjectCode(subjectCode);
        Transcript transcript = transcriptRepository.findBySubject(subject);
        model.addAttribute("transcript",transcript);
        return "/adminview/transcript-info";
    }

    // display image
    @GetMapping("/imageEmployee")
    public ResponseEntity<byte[]> displayImage2(@RequestParam("id") int id) throws IOException, SQLException
    {
        Employee employee = employeeRepository.getById(id);
        byte [] imageBytes = null;
        imageBytes = employee.getAvatar().getBytes(1,(int) employee.getAvatar().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @GetMapping("/employeeName")
    public ResponseEntity<String> displayImage4(@RequestParam("userName") String name) throws IOException, SQLException
    {
        Account account = accountRepository.findByUserName(name);
        Employee employee = employeeRepository.findByAccount(account);
        String employeeLastName = employee.getLastName();
        return ResponseEntity.ok().body(employeeLastName);
    }

    @GetMapping("/studentName")
    public ResponseEntity<String> displayImage5(@RequestParam("userName") String name) throws IOException, SQLException
    {
        Account account = accountRepository.findByUserName(name);
        Student student = studentRepository.findByAccount(account);
        String studentName = student.getLastName();
        return ResponseEntity.ok().body(studentName);
    }
}
