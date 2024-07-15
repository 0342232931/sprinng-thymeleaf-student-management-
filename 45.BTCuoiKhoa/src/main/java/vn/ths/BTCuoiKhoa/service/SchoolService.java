package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.RoleRepository;
import vn.ths.BTCuoiKhoa.dao.SchoolRepository;
import vn.ths.BTCuoiKhoa.entity.Role;
import vn.ths.BTCuoiKhoa.entity.School;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService implements MyService<School>{
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School getById(int id) {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        return optionalSchool.orElse(null);
    }

    @Override
    @Transactional
    public School add(School school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    @Transactional
    public School update(School school) {
        Optional<School> optionalSchool = schoolRepository.findById(school.getId());
        if(optionalSchool.isPresent()){
            return schoolRepository.saveAndFlush(school);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School findByName(String name) {
        return schoolRepository.findBySchoolName(name);
    }
}
