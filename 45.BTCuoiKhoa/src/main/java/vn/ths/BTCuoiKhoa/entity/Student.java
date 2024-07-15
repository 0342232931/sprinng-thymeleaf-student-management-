package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
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

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Transcript> transcripts;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private SchoolProfile schoolProfile;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ReportCard> reportCards;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "student")
    private StudentCard studentCard;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phoneNumber, boolean gender, Date dateOfBirth, ClassRoom classRoom, Parent parent, List<Transcript> transcripts, SchoolProfile schoolProfile, List<ReportCard> reportCards, StudentCard studentCard, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.classRoom = classRoom;
        this.parent = parent;
        this.transcripts = transcripts;
        this.schoolProfile = schoolProfile;
        this.reportCards = reportCards;
        this.studentCard = studentCard;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public SchoolProfile getSchoolProfile() {
        return schoolProfile;
    }

    public void setSchoolProfile(SchoolProfile schoolProfile) {
        this.schoolProfile = schoolProfile;
    }

    public List<ReportCard> getReportCards() {
        return reportCards;
    }

    public void setReportCards(List<ReportCard> reportCards) {
        this.reportCards = reportCards;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", classRoom=" + classRoom +
                ", parent=" + parent +
                ", transcripts=" + transcripts +
                ", schoolProfile=" + schoolProfile +
                ", reportCards=" + reportCards +
                ", studentCard=" + studentCard +
                ", account=" + account +
                '}';
    }
}
