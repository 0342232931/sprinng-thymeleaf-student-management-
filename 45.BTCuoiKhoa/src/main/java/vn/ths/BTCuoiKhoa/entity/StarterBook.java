package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

@Entity
@Table(name = "starter_book")
public class StarterBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "content")
    private String content;

    @Column(name = "teaching_day")
    private Date teachingDay;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public StarterBook() {
    }

    public StarterBook(String content, Date teaching_day, ClassRoom classRoom, Employee employee) {
        this.content = content;
        this.teachingDay = teaching_day;
        this.classRoom = classRoom;
        this.employee = employee;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTeaching_day() {
        return teachingDay;
    }

    public void setTeaching_day(Date teaching_day) {
        this.teachingDay = teaching_day;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StarterBook{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", teaching_day=" + teachingDay +
                ", classRoom=" + classRoom +
                ", employee=" + employee +
                '}';
    }
}
