package vn.ths.BTCuoiKhoa.controller;

import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.ths.BTCuoiKhoa.dao.EmployeeRepository;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/teacherGetAll")
public class TeacherGetListController {

    private MyService<Account> accountMyService;
    private EmployeeRepository employeeRepository;

    @Autowired
    public TeacherGetListController(MyService<Account> accountMyService,EmployeeRepository employeeRepository) {
        this.accountMyService = accountMyService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/student")
    public String getList1(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(employee.getPosition().equals("GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            List<Student> list = classRoom.getStudent();
            model.addAttribute("students", list);
            return "/adminview/student-info";
        }
        return "/error/403";
    }

    @GetMapping("/reportCard")
    public String getList2(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(employee.getPosition().equals("GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            List<Student> students = classRoom.getStudent();
            List<ReportCard> reportCards = new ArrayList<>();
            for (Student student : students) {
                List<ReportCard> list = student.getReportCards();
                reportCards.addAll(list);
            }
            model.addAttribute("reportCard", reportCards);
            return "/adminview/reportcard-info";
        }
        return "/error/403";
    }

    @GetMapping("/schoolProfile")
    public String getList3(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(Objects.equals(employee.getPosition(), "GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            List<Student> students = classRoom.getStudent();
            List<SchoolProfile> schoolProfiles = new ArrayList<>();
            for (Student student : students) {
                schoolProfiles.add(student.getSchoolProfile());
            }
            model.addAttribute("reportCard", schoolProfiles);
            return "/adminview/schoolprofile-info";
        }
        return "/error/403";
    }

    @GetMapping("/starterBook")
    public String getList4(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(Objects.equals(employee.getPosition(), "GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            StarterBook starterBook = classRoom.getStarterBook();
            model.addAttribute("starterBook", starterBook);
            return "/adminview/starterbook-info";
        }
        return "/error/403";
    }

    @GetMapping("/studentCard")
    public String getList5(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(employee.getPosition().equals("GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            List<Student> students = classRoom.getStudent();
            List<StudentCard> studentCards = new ArrayList<>();
            for (Student student : students) {
                studentCards.add(student.getStudentCard());
            }
            model.addAttribute("studentCard", studentCards);
            return "/adminview/studentcard-info";
        }
        return "/error/403";
    }

    @GetMapping("/subject")
    public String getList6(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(Objects.equals(employee.getPosition(), "GVCN")) {
            Subject subject = employee.getSubject();
            model.addAttribute("subject", subject);
            return "/adminview/subject-info";
        }
        return "/error/403";
    }

    @GetMapping("/class")
    public String getList7(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(Objects.equals(employee.getPosition(), "GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            model.addAttribute("class", classRoom);
            return "/adminview/class-info";
        }
        return "/error/403";
    }

    @GetMapping("/transcript")
    public String getList8(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        Account account = accountMyService.findByName(userName);
        Employee employee = employeeRepository.findByAccount(account);
        if(Objects.equals(employee.getPosition(), "GVCN")) {
            ClassRoom classRoom = employee.getClassRoom();
            List<Student> list = classRoom.getStudent();
            List<Transcript> listTranscript = new ArrayList<>();
            for(Student student : list){
                List<Transcript> transcripts = student.getTranscripts();
                listTranscript.addAll(transcripts);
            }
            model.addAttribute("transcript", listTranscript);
            return "/adminview/transcript-info";
        }
        return "/error/403";
    }
}
