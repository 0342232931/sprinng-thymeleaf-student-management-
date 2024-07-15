package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.ReportCard;
import vn.ths.BTCuoiKhoa.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    public Subject findBySubjectName(String name);
    public Subject findBySubjectCode(String code);
    @Query("SELECT a FROM Subject a JOIN FETCH a.employee JOIN FETCH a.transcripts JOIN FETCH a.reportCards WHERE a.id=:id")
    public Subject findSubjectByIdJoinFetch(int id);
}
