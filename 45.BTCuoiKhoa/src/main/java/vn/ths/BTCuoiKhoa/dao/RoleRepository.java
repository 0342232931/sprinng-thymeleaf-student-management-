package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Employee;
import vn.ths.BTCuoiKhoa.entity.Role;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findRoleByRole(String role);

    @Query("SELECT a FROM Role a JOIN FETCH a.accounts WHERE a.id=:id")
    public Role findRoleByIdJoinFetch(int id);
}
