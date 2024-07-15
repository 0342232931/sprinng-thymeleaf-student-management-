package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    public Account findByUserName(String userName);

    @Query("SELECT a FROM Account a JOIN FETCH a.role WHERE a.id=:id")
    public Account findAccountByIdJoinFetch(int id);
}
