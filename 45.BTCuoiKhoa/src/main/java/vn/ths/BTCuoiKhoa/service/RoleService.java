package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.ReportCardRepository;
import vn.ths.BTCuoiKhoa.dao.RoleRepository;
import vn.ths.BTCuoiKhoa.entity.ReportCard;
import vn.ths.BTCuoiKhoa.entity.Role;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements MyService<Role>{
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(int id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.orElse(null);
    }

    @Override
    @Transactional
    public Role add(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    @Transactional
    public Role update(Role role) {
        Optional<Role> optionalRole = roleRepository.findById(role.getId());
        if(optionalRole.isPresent()){
            return roleRepository.saveAndFlush(role);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findRoleByRole(name);
    }
}
