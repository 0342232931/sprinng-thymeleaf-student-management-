package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.ReportCardRepository;
import vn.ths.BTCuoiKhoa.entity.ClassRoom;
import vn.ths.BTCuoiKhoa.entity.ReportCard;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCardService implements MyService<ReportCard>{
    private ReportCardRepository reportCardRepository;

    @Autowired
    public ReportCardService(ReportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }

    @Override
    public List<ReportCard> getAll() {
        return reportCardRepository.findAll();
    }

    @Override
    public ReportCard getById(int id) {
        Optional<ReportCard> optionalReportCard = reportCardRepository.findById(id);
        return optionalReportCard.orElse(null);
    }

    @Override
    @Transactional
    public ReportCard add(ReportCard reportCard) {
        return reportCardRepository.saveAndFlush(reportCard);
    }

    @Override
    @Transactional
    public ReportCard update(ReportCard reportCard) {
        Optional<ReportCard> optionalReportCard = reportCardRepository.findById(reportCard.getId());
        if(optionalReportCard.isPresent()){
            return reportCardRepository.saveAndFlush(reportCard);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        reportCardRepository.deleteById(id);
    }

    @Override
    public ReportCard findByName(String name) {
        return reportCardRepository.findByTitle(name);
    }
}
