package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "school_name")
    private String schoolName;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "school",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<ClassRoom> classRooms;

    public School() {
    }

    public School(String schoolName, String address, String phoneNumber, List<ClassRoom> classRooms) {
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classRooms = classRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
