package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.StarterBook;
import vn.ths.BTCuoiKhoa.entity.Transcript;

import java.sql.Date;

@Repository
public interface StarterBookRepository extends JpaRepository<StarterBook,Integer> {
    public StarterBook findByTeachingDay(Date date);
    @Query("SELECT a FROM StarterBook a JOIN FETCH a.classRoom JOIN FETCH a.employee WHERE a.id=:id")
    public StarterBook findStarterBookByIdJoinFetch(int id);
}
