package vn.ths.BTCuoiKhoa.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.ths.BTCuoiKhoa.dao.ClassRoomRepository;
import vn.ths.BTCuoiKhoa.dao.EmployeeRepository;
import vn.ths.BTCuoiKhoa.entity.ClassRoom;
import vn.ths.BTCuoiKhoa.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements MyService<Employee> {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    @Transactional
    public Employee add(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            return employeeRepository.saveAndFlush(employee);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByLastName(name);
    }
}
