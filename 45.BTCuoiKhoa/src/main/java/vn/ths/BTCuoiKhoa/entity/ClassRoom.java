package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Table(name = "class_room")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "class_name")
    private String className;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "nien_khoa")
    private String nienKhoa;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "khoi_hoc")
    private String khoiHoc;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "school_id")
    private School school;

    @OneToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "classRoom",fetch = FetchType.LAZY,
                cascade = {
                        CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH}
    )
    private List<Student> student;

    @OneToOne(mappedBy = "classRoom",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private StarterBook starterBook;

    public ClassRoom(String className, String nienKhoa, String khoiHoc, School school, Employee employee, List<Student> student, StarterBook starterBook) {
        this.className = className;
        this.nienKhoa = nienKhoa;
        this.khoiHoc = khoiHoc;
        this.school = school;
        this.employee = employee;
        this.student = student;
        this.starterBook = starterBook;
    }

    public ClassRoom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getKhoiHoc() {
        return khoiHoc;
    }

    public void setKhoiHoc(String khoiHoc) {
        this.khoiHoc = khoiHoc;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public StarterBook getStarterBook() {
        return starterBook;
    }

    public void setStarterBook(StarterBook starterBook) {
        this.starterBook = starterBook;
    }
}
