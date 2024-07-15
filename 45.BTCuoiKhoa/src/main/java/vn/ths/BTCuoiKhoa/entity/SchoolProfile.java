package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "school_profile")
public class SchoolProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "medium_score")
    private float mediumScore;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "hanh_kiem")
    private String hanhKiem;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "note_teacher")
    private String noteTeacher;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "note_parent")
    private String noteParent;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public SchoolProfile() {
    }

    public SchoolProfile(float mediumScore, String hanhKiem, String noteTeacher, String noteParent, Student student) {
        this.mediumScore = mediumScore;
        this.hanhKiem = hanhKiem;
        this.noteTeacher = noteTeacher;
        this.noteParent = noteParent;
        this.student = student;
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public String getNoteTeacher() {
        return noteTeacher;
    }

    public void setNoteTeacher(String noteTeacher) {
        this.noteTeacher = noteTeacher;
    }

    public String getNoteParent() {
        return noteParent;
    }

    public void setNoteParent(String noteParent) {
        this.noteParent = noteParent;
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
        return "SchoolProfile{" +
                "mediumScore=" + mediumScore +
                ", hanhKiem='" + hanhKiem + '\'' +
                ", noteTeacher='" + noteTeacher + '\'' +
                ", noteParent='" + noteParent + '\'' +
                ", id=" + id +
                '}';
    }
}
