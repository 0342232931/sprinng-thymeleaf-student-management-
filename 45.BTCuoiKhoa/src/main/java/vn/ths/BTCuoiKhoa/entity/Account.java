package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int  id;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Size(min = 5,message = "Độ Dài Tối Thiểu Là 5 Kí Tự")
    @Column(name = "user_name",length = 255, unique = true)
    private String userName;

    @NotBlank(message = "Phần Này Không Được Để Trống")
    @Size(min = 5,message = "Độ Dài Tối Thiểu Là 5 Kí Tự")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@!#$%^&+=])(?=\\S+$).*$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ số và 1 ký tự đặc biệt")
    @Column(name = "password", length = 255)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> role;

    @Column(name = "active")
    private boolean active;

    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Parent parent;

    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employee employee;

    public Account() {
    }

    public Account(String userName, String password, List<Role> role, boolean active, Student student, Parent parent, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.active = active;
        this.student = student;
        this.parent = parent;
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + active +
                ", student=" + student +
                ", parent=" + parent +
                ", employee=" + employee +
                '}';
    }
}
