package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "parent")
public class Parent {
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

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "avatar")
    @Lob
    private Blob avatar;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Student> students;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Parent() {
    }

    public Parent(String firstName, String lastName, String email, String phoneNumber, boolean gender, Blob avatar, Date dateOfBirth, List<Student> students, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.students = students;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "dateOfBirth=" + dateOfBirth +
                ", avatar=" + avatar +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
