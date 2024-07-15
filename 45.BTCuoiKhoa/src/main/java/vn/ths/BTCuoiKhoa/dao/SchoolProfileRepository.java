package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.*;

@Repository
public interface SchoolProfileRepository extends JpaRepository<SchoolProfile,Integer> {
    public SchoolProfile findByStudent(Student student);

    @Query("SELECT a FROM SchoolProfile a JOIN FETCH a.student WHERE a.id=:id")
    public SchoolProfile findSchoolProfileByIdJoinFetch(int id);
}
