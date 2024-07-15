package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.SchoolRepository;
import vn.ths.BTCuoiKhoa.dao.StudentCardRepository;
import vn.ths.BTCuoiKhoa.entity.School;
import vn.ths.BTCuoiKhoa.entity.StudentCard;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCardService implements MyService<StudentCard>{
    private StudentCardRepository studentCardRepository;

    @Autowired
    public StudentCardService(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    @Override
    public List<StudentCard> getAll() {
        return studentCardRepository.findAll();
    }

    @Override
    public StudentCard getById(int id) {
        Optional<StudentCard> optionalStudentCard = studentCardRepository.findById(id);
        return optionalStudentCard.orElse(null);
    }

    @Override
    @Transactional
    public StudentCard add(StudentCard studentCard) {
        return studentCardRepository.saveAndFlush(studentCard);
    }

    @Override
    @Transactional
    public StudentCard update(StudentCard studentCard) {
        Optional<StudentCard> optionalStudentCard = studentCardRepository.findById(studentCard.getId());
        if(optionalStudentCard.isPresent()){
            return studentCardRepository.saveAndFlush(studentCard);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentCardRepository.deleteById(id);
    }

    @Override
    public StudentCard findByName(String name) {
        return studentCardRepository.findByLastName(name);
    }
}
