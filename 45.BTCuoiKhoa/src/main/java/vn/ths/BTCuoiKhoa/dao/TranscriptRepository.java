package vn.ths.BTCuoiKhoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.ths.BTCuoiKhoa.entity.Subject;
import vn.ths.BTCuoiKhoa.entity.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript,Integer> {
    public Transcript findBySubject(Subject subject);

    @Query("SELECT a FROM Transcript a JOIN FETCH a.student JOIN FETCH a.subject WHERE a.id=:id")
    public Transcript findTranscriptByIdJoinFetch(int id);
}
