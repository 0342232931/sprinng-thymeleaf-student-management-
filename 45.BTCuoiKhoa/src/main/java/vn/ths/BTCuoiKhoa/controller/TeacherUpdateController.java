package vn.ths.BTCuoiKhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

@Controller
@RequestMapping("/teacherUpdate")
public class TeacherUpdateController {
    private MyService<Student> studentMyService;
    private MyService<ClassRoom> classRoomMyService;
    private MyService<ReportCard> reportCardMyService;
    private MyService<SchoolProfile> schoolProfileMyService;
    private MyService<StarterBook> starterBookMyService;
    private MyService<StudentCard> service;
    private MyService<Subject> subjectMyService;
    private MyService<Transcript> transcriptMyService;

    @Autowired
    public TeacherUpdateController(MyService<Student> studentMyService, MyService<ClassRoom> classRoomMyService, MyService<ReportCard> reportCardMyService, MyService<SchoolProfile> schoolProfileMyService, MyService<StarterBook> starterBookMyService, MyService<StudentCard> service, MyService<Subject> subjectMyService, MyService<Transcript> transcriptMyService) {
        this.studentMyService = studentMyService;
        this.classRoomMyService = classRoomMyService;
        this.reportCardMyService = reportCardMyService;
        this.schoolProfileMyService = schoolProfileMyService;
        this.starterBookMyService = starterBookMyService;
        this.service = service;
        this.subjectMyService = subjectMyService;
        this.transcriptMyService = transcriptMyService;
    }
    @GetMapping("/student")
    public String Save1(@RequestParam("id") int id, Model model){
        Student student = studentMyService.getById(id);
        model.addAttribute("student",student);
        return "/admincreate/student-create";
    }

    @GetMapping("/reportCard")
    public String Save5(@RequestParam("id") int id, Model model){
        ReportCard reportCard = reportCardMyService.getById(id);
        model.addAttribute("reportCard",reportCard);
        return "/admincreate/reportcard-create";
    }

    @GetMapping("/schoolProfile")
    public String Save8(@RequestParam("id") int id, Model model){
        SchoolProfile schoolProfile = schoolProfileMyService.getById(id);
        model.addAttribute("schoolProfile",schoolProfile);
        return "/admincreate/schoolprofile-create";
    }

    @GetMapping("/starterBook")
    public String Save9(@RequestParam("id") int id, Model model){
        StarterBook starterBook = starterBookMyService.getById(id);
        model.addAttribute("starterBook",starterBook);
        return "/admincreate/starterbook-create";
    }

    @GetMapping("/studentCard")
    public String Save10(@RequestParam("id") int id, Model model){
        StudentCard studentCard = service.getById(id);
        model.addAttribute("studentCard",studentCard);
        return "/admincreate/studentcard-create";
    }

    @GetMapping("/subject")
    public String Save11(@RequestParam("id") int id, Model model){
        Subject subject = subjectMyService.getById(id);
        model.addAttribute("student",subject);
        return "/admincreate/subject-create";
    }

    @GetMapping("/transcript")
    public String Save12(@RequestParam("id") int id, Model model){
        Transcript transcript = transcriptMyService.getById(id);
        model.addAttribute("transcript",transcript);
        return "/admincreate/transcript-create";
    }

    @GetMapping("/class")
    public String save13(@RequestParam("id") int id, Model model){
        ClassRoom classRoom = classRoomMyService.getById(id);
        model.addAttribute("classRoom",classRoom);
        return "/admincreate/classroom-create";
    }
}
