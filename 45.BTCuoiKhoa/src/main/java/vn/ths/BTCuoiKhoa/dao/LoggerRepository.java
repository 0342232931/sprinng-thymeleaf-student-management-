package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger,Integer> {
}
