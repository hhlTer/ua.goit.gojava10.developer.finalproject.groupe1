package factorymanagment.service.repository;

import factorymanagment.model.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Query(nativeQuery = true,
    value = "SELECT * FROM employee WHERE salary_per_hour < :questSalary")
    ArrayList<Employee> getPerSalarySmallastThen(@RequestParam("questSalary") BigDecimal sst);

    @Query
    Employee getByAccount_Login(String login);
}
