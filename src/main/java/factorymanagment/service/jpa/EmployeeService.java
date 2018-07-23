package factorymanagment.service.jpa;

import factorymanagment.model.domain.Employee;
import factorymanagment.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmpoloyee(){
        return employeeRepository.findAll();
    }

    public Employee getByUsername(String username) {
        return employeeRepository.getByAccount_Login(username);
    }
}
