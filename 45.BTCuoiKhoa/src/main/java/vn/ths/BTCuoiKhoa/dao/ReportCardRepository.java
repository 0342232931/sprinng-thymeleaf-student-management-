package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.ReportCard;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCard,Integer> {
    public ReportCard findByTitle(String title);

    @Query("SELECT a FROM ReportCard a JOIN FETCH a.subject JOIN FETCH a.student WHERE a.id=:id")
    public ReportCard findReportCardByIdJoinFetch(int id);
}
