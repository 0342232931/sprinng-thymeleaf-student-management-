package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.School;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
    public School findBySchoolName(String name);

    @Query("SELECT a FROM School a JOIN FETCH a.classRooms WHERE a.id=:id")
    public School findSchoolByIdJoinFetch(int id);
}
