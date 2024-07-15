package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Employee findByLastName(String name);
    public Employee findByAccount(Account account);

    @Query("SELECT a FROM Employee a JOIN FETCH a.classRoom JOIN FETCH a.subject JOIN FETCH a.starterBooks JOIN FETCH a.account WHERE a.id=:id")
    public Employee findEmployeeByIdJoinFetch(int id);
}
