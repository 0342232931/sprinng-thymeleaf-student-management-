package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.StudentRepository;
import vn.ths.BTCuoiKhoa.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements MyService<Student>{
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    @Transactional
    public Student add(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if(optionalStudent.isPresent()){
            return studentRepository.saveAndFlush(student);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByLastName(name);
    }
}
