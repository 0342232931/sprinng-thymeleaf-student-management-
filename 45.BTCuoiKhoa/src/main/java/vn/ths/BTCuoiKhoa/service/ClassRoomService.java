package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.ClassRoomRepository;
import vn.ths.BTCuoiKhoa.entity.ClassRoom;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService implements MyService<ClassRoom> {

    private ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public List<ClassRoom> getAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getById(int id) {
        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(id);
        return optionalClassRoom.orElse(null);
    }

    @Override
    @Transactional
    public ClassRoom add(ClassRoom classRoom) {
        return classRoomRepository.saveAndFlush(classRoom);
    }

    @Override
    @Transactional
    public ClassRoom update(ClassRoom classRoom) {
        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(classRoom.getId());
        if(optionalClassRoom.isPresent()){
            return classRoomRepository.saveAndFlush(classRoom);
        }else
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        classRoomRepository.deleteById(id);
    }

    @Override
    public ClassRoom findByName(String name) {
        return classRoomRepository.findByClassName(name);
    }
}
