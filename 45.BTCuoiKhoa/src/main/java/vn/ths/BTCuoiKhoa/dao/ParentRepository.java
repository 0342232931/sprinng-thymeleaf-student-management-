package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.Parent;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {
    public Parent findByLastName(String name);

    @Query("SELECT a FROM Parent a JOIN FETCH a.students JOIN FETCH a.account WHERE a.id=:id")
    public Parent finaParentByIdJoinFetch(int id);
}
