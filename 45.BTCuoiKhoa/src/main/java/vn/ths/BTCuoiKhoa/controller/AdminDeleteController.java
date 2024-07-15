package vn.ths.BTCuoiKhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.ths.BTCuoiKhoa.entity.*;
import vn.ths.BTCuoiKhoa.service.MyService;

@Controller
@RequestMapping("/delete")
public class AdminDeleteController {
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
        public AdminDeleteController(MyService<Student> studentMyService, MyService<School> schoolMyService, MyService<ClassRoom> classRoomMyService, MyService<Employee> employeeMyService, MyService<Parent> parentMyService, MyService<ReportCard> reportCardMyService, MyService<Role> roleMyService, MyService<Account> accountMyService, MyService<SchoolProfile> schoolProfileMyService, MyService<StarterBook> starterBookMyService, MyService<StudentCard> service, MyService<Subject> subjectMyService, MyService<Transcript> transcriptMyService) {
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
        @GetMapping("/student")
        public String Save1(@RequestParam("id") int id){
            Student student = studentMyService.getById(id);
            student.setParent(null);
            student.setClassRoom(null);
            studentMyService.add(student);
            studentMyService.deleteById(id);
            return "redirect:/getAll/studentInfo";
        }

        @GetMapping("/account")
        public String Save2(@RequestParam("id") int id){
            accountMyService.deleteById(id);
            return "redirect:/getAll/accountInfo";
        }

        @GetMapping("/employee")
        public String Save3(@RequestParam("id") int id){
            employeeMyService.deleteById(id);
            return "redirect:/getAll/employeeInfo";
        }

        @GetMapping("/parent")
        public String Save4(@RequestParam("id") int id){
            parentMyService.deleteById(id);
            return "redirect:/getAll/parentInfo";
        }

        @GetMapping("/reportCard")
        public String Save5(@RequestParam("id") int id){
            ReportCard reportCard = reportCardMyService.getById(id);
            reportCard.setSubject(null);
            reportCardMyService.add(reportCard);
            reportCardMyService.deleteById(id);
            return "redirect:/getAll/reportCardInfo";
        }

        @GetMapping("/role")
        public String Save6(@RequestParam("id") int id){
            roleMyService.deleteById(id);
            return "redirect:/getAll/roleInfo";
        }

        @GetMapping("/school")
        public String Save7(@RequestParam("id") int id){
            schoolMyService.deleteById(id);
            return "redirect:/getAll/schoolInfo";
        }

        @GetMapping("/schoolProfile")
        public String Save8(@RequestParam("id") int id){
            schoolProfileMyService.deleteById(id);
            return "redirect:/getAll/schoolProfileInfo";
        }

        @GetMapping("/starterBook")
        public String Save9(@RequestParam("id") int id){
            starterBookMyService.deleteById(id);
            return "redirect:/getAll/starterBookInfo";
        }

        @GetMapping("/studentCard")
        public String Save10(@RequestParam("id") int id){
            service.deleteById(id);
            return "redirect:/getAll/studentCardInfo";
        }

        @GetMapping("/subject")
        public String Save11(@RequestParam("id") int id){
           subjectMyService.deleteById(id);
            return "redirect:/getAll/subjectInfo";
        }

        @GetMapping("/transcript")
        public String Save12(@RequestParam("id") int id){
            Transcript transcript = transcriptMyService.getById(id);
            transcript.setStudent(null);
            transcript.setSubject(null);
            transcriptMyService.add(transcript);
            transcriptMyService.deleteById(id);
            return "redirect:/getAll/transcriptInfo";
        }

        @GetMapping("/class")
        public String save13(@RequestParam("id") int id){
            ClassRoom classRoom = classRoomMyService.getById(id);
            classRoom.setSchool(null);
            classRoomMyService.add(classRoom);
            classRoomMyService.deleteById(id);
            return "redirect:/getAll/classInfo";
        }
    }


