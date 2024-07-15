package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "subject_code")
    private String subjectCode;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "subject_name")
    private String subjectName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Transcript> transcripts;

    @OneToMany(mappedBy = "subject",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ReportCard> reportCards;

    public Subject() {
    }

    public Subject(String subjectCode, String subjectName, Employee employee, List<Transcript> transcripts, List<ReportCard> reportCards) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.employee = employee;
        this.transcripts = transcripts;
        this.reportCards = reportCards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public List<ReportCard> getReportCards() {
        return reportCards;
    }

    public void setReportCards(List<ReportCard> reportCards) {
        this.reportCards = reportCards;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", employee=" + employee +
                ", transcripts=" + transcripts +
                ", reportCards=" + reportCards +
                '}';
    }
}
