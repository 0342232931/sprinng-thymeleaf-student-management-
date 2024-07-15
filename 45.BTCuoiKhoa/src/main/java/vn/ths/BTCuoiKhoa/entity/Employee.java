package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

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

    @Email(message = "Phần Này Không Được Để Trống")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar")
    @Lob
    private Blob avatar;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private boolean gender;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "position")
    private String position;

    @OneToOne(mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private ClassRoom classRoom;

    @OneToOne(mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private Subject subject;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<StarterBook> starterBooks;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, Blob avatar, Date dateOfBirth, boolean gender, String position, ClassRoom classRoom, Subject subject, List<StarterBook> starterBooks, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.position = position;
        this.classRoom = classRoom;
        this.subject = subject;
        this.starterBooks = starterBooks;
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

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar1) {
            this.avatar = avatar1;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<StarterBook> getStarterBooks() {
        return starterBooks;
    }

    public void setStarterBooks(List<StarterBook> starterBooks) {
        this.starterBooks = starterBooks;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar=" + avatar +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", position='" + position + '\'' +
                '}';
    }

}
