package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.Student;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findByLastName(String name);
    public Student findByAccount(Account account);

    @Query("SELECT a FROM Student a JOIN FETCH a.classRoom JOIN FETCH a.parent JOIN FETCH a.transcripts JOIN FETCH a.schoolProfile " +
            "JOIN FETCH a.reportCards JOIN FETCH a.studentCard JOIN FETCH a.account WHERE a.id=:id")
    public Student findStudentByIdJoinFetch(int id);
}
