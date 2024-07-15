package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.ParentRepository;
import vn.ths.BTCuoiKhoa.entity.ClassRoom;
import vn.ths.BTCuoiKhoa.entity.Parent;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService implements MyService<Parent>{
    private ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getById(int id) {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        return optionalParent.orElse(null);
    }

    @Override
    @Transactional
    public Parent add(Parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    @Transactional
    public Parent update(Parent parent) {
        Optional<Parent> optionalParent = parentRepository.findById(parent.getId());
        if(optionalParent.isPresent()){
            return parentRepository.saveAndFlush(parent);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Parent findByName(String name) {
        return parentRepository.findByLastName(name);
    }
}
