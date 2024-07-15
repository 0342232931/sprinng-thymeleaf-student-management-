package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.ClassRoom;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Integer> {
    public ClassRoom findByClassName(String name);

    @Query("SELECT c FROM ClassRoom c JOIN FETCH c.school JOIN FETCH c.student JOIN FETCH c.employee JOIN FETCH c.starterBook WHERE c.id=:id")
    public ClassRoom findClassRoomByIdJoinFetch(int id);
}
