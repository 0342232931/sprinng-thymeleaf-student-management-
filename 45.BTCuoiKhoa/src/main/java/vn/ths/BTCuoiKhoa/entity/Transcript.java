package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "transcript")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "ky_hoc")
    private String kyHoc;

    @Column(name = "record")
    private float record;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Transcript() {
    }

    public Transcript(String kyHoc, float record, Student student, Subject subject) {
        this.kyHoc = kyHoc;
        this.record = record;
        this.student = student;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public float getRecord() {
        return record;
    }

    public void setRecord(float record) {
        this.record = record;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "id=" + id +
                ", kyHoc='" + kyHoc + '\'' +
                ", record=" + record +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
