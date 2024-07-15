package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.SubjectRepository;
import vn.ths.BTCuoiKhoa.entity.Subject;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements MyService<Subject>{
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(int id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        return optionalSubject.orElse(null);
    }

    @Override
    @Transactional
    public Subject add(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    @Transactional
    public Subject update(Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subject.getId());
        if(optionalSubject.isPresent()){
            return subjectRepository.saveAndFlush(subject);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject findByName(String name) {
        return subjectRepository.findBySubjectName(name);
    }
}
