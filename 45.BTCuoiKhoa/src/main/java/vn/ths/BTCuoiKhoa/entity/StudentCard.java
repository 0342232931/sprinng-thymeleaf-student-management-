package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Blob;

@Entity
@Table(name = "student_card")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private boolean gender;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    @Lob
    private Blob avatar;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentCard() {
    }

    public StudentCard(String firstName, String lastName, boolean gender, String address, Blob avatar, Student student) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.student = student;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentCard{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", avatar=" + avatar +
                ", student=" + student +
                '}';
    }
}
