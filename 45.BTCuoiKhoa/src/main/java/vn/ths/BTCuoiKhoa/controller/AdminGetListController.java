package vn.ths.BTCuoiKhoa.controller;

import jakarta.persistence.EntityManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/getAll", method = RequestMethod.GET)
public class AdminGetListController {
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

    @Autowired
    public AdminGetListController(MyService<Student> studentMyService, MyService<School> schoolMyService, MyService<ClassRoom> classRoomMyService, MyService<Employee> employeeMyService, MyService<Parent> parentMyService, MyService<ReportCard> reportCardMyService, MyService<Role> roleMyService, MyService<Account> accountMyService, MyService<SchoolProfile> schoolProfileMyService, MyService<StarterBook> starterBookMyService, MyService<StudentCard> service, MyService<Subject> subjectMyService, MyService<Transcript> transcriptMyService) {
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
    }

    @GetMapping("/classInfo")
    public String classInfo(Model model){
        List<ClassRoom> list = classRoomMyService.getAll();
        model.addAttribute("class",list);
        return "/adminview/class-info";
    }

    // view All employee
    @GetMapping("/employeeInfo")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("/adminview/employee-info");
        List<Employee> employees = employeeMyService.getAll();
        mv.addObject("employee", employees);
        return mv;
    }

    // display image
    @GetMapping("/displayemployee")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") int id) throws IOException, SQLException {
        Employee employee = employeeMyService.getById(id);
        if(employee == null || employee.getAvatar() == null){
            return ResponseEntity.notFound().build();
        }
        byte [] imageBytes = null;
        imageBytes = employee.getAvatar().getBytes(1,(int) employee.getAvatar().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    // view All parent
    @GetMapping("/parentInfo")
    public ModelAndView home2(){
        ModelAndView mv = new ModelAndView("/adminview/parent-info");
        List<Parent> parents = parentMyService.getAll();
        mv.addObject("parent", parents);
        return mv;
    }

    // display image
    @GetMapping("/displayparent")
    public ResponseEntity<byte[]> displayImage2(@RequestParam("id") int id) throws IOException, SQLException
    {
        Parent parent = parentMyService.getById(id);
        byte [] imageBytes = null;
        imageBytes = parent.getAvatar().getBytes(1,(int) parent.getAvatar().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @GetMapping("/reportCardInfo")
    public String reportCardInfo(Model model){
        List<ReportCard> list = reportCardMyService.getAll();
        model.addAttribute("reportCard",list);
        return "/adminview/reportcard-info";
    }

    @GetMapping("/roleInfo")
    public String roleInfo(Model model){
        List<Role> list = roleMyService.getAll();
        model.addAttribute("role",list);
        return "/adminview/role-info";
    }

    @GetMapping("/accountInfo")
    public String accountInfo(Model model){
        List<Account> list = accountMyService.getAll();
        model.addAttribute("account",list);
        return "/adminview/account-info";
    }

    @GetMapping("/schoolProfileInfo")
    public String schoolProfileInfo(Model model){
        List<SchoolProfile> list = schoolProfileMyService.getAll();
        model.addAttribute("schoolProfile",list);
        return "/adminview/schoolprofile-info";
    }

    @GetMapping("/starterBookInfo")
    public String starterBookInfo(Model model){
        List<StarterBook> list = starterBookMyService.getAll();
        model.addAttribute("starterBook",list);
        return "/adminview/starterbook-info";
    }

    // view All employee
    @GetMapping("/studentCardInfo")
    public ModelAndView home3(){
        ModelAndView mv = new ModelAndView("/adminview/studentCard-info");
        List<StudentCard> studentCards = service.getAll();
        mv.addObject("studentCard", studentCards);
        return mv;
    }

    // display image
    @GetMapping("/displaystudentcard")
    public ResponseEntity<byte[]> displayImage3(@RequestParam("id") int id) throws IOException, SQLException
    {
        StudentCard studentCard = service.getById(id);
        byte [] imageBytes = null;
        imageBytes = studentCard.getAvatar().getBytes(1,(int) studentCard.getAvatar().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @GetMapping("/subjectInfo")
    public String subjectInfo(Model model){
        List<Subject> list = subjectMyService.getAll();
        model.addAttribute("subject",list);
        return "/adminview/subject-info";
    }

    @GetMapping("/transcriptInfo")
    public String transcriptInfo(Model model){
        List<Transcript> list = transcriptMyService.getAll();
        model.addAttribute("transcript",list);
        return "/adminview/transcript-info";
    }

    @GetMapping("/schoolInfo")
    public String schoolInfo(Model model){
        List<School> list = schoolMyService.getAll();
        model.addAttribute("school",list);
        return "/adminview/school-info";
    }

    @GetMapping("/studentInfo")
    public String MyInfo(Model model){
        List<Student> list = studentMyService.getAll();
        model.addAttribute("students",list);
        return "/adminview/student-info";
    }
}
