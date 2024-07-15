package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.RoleRepository;
import vn.ths.BTCuoiKhoa.dao.SchoolProfileRepository;
import vn.ths.BTCuoiKhoa.entity.SchoolProfile;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolProfileService implements MyService<SchoolProfile>{
    private SchoolProfileRepository schoolProfileRepository;

    @Autowired
    public SchoolProfileService(SchoolProfileRepository schoolProfileRepository) {
        this.schoolProfileRepository = schoolProfileRepository;
    }

    @Override
    public List<SchoolProfile> getAll() {
        return schoolProfileRepository.findAll();
    }

    @Override
    public SchoolProfile getById(int id) {
        Optional<SchoolProfile> optionalSchoolProfile = schoolProfileRepository.findById(id);
        return optionalSchoolProfile.orElse(null);
    }

    @Override
    @Transactional
    public SchoolProfile add(SchoolProfile schoolProfile) {
        return schoolProfileRepository.saveAndFlush(schoolProfile);
    }

    @Override
    @Transactional
    public SchoolProfile update(SchoolProfile schoolProfile) {
        Optional<SchoolProfile> optionalSchoolProfile = schoolProfileRepository.findById(schoolProfile.getId());
        if(optionalSchoolProfile.isPresent()){
            return schoolProfileRepository.saveAndFlush(schoolProfile);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        schoolProfileRepository.deleteById(id);
    }

    @Override
    public SchoolProfile findByName(String name) {
        return null;
    }
}
