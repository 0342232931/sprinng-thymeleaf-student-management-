package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.StudentCard;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard,Integer> {
    public StudentCard findByLastName(String name);


    @Query("SELECT a FROM StudentCard a JOIN FETCH a.student WHERE a.id=:id")
    public StudentCard findStudentCardByIdJoinFetch(int id);
}
