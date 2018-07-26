package factorymanagment.service.repository;

import factorymanagment.model.domain.Employee;
import factorymanagment.model.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Query(nativeQuery = true,
    value = "SELECT * FROM employee WHERE salary_per_hour < :questSalary")
    ArrayList<Employee> getPerSalarySmallastThen(@RequestParam("questSalary") BigDecimal sst);

    @Query
    Employee getByAccount_Login(String login);

    /**
     * get all employees who work in period from
     * @param fromDate to
     * @param toDate
     * and exist in
     * @param eventId
     *
     * @return TODO: distinct
     */
    @Query(nativeQuery = true,
    value = "select employee.id from employee\n" +
            "left join event_schedule on employee_id = employee.id\n" +
            "left join date_table on date_date_string_id = date_table.date_string_id\n" +
            "where event_schedule.event_id = :eId\n" +
            "and date_table.date > :fd and date_table.date < :td;")
    List<Employee> getAllWhoInEventInPeriod(
            @Param("eId") Long eventId,
            @Param("fd") Date fromDate,
            @Param("td") Date toDate);

    /**
     * =========================Test query =====================
     * @param fromDate
     * @param toDate
     * @param statusId
     * @return
     */
    @Query
    List<Employee> getAllByStatusScheduleSetBetweenAndStatusScheduleSet(Date fromDate, Date toDate, long statusId);
//    List<Employee> getAllEmployeesFromPeriodWhoHaveStatus(int id, Date fromDate, Date toDate);

    @Query
    Employee save(Employee employee);

    @Query
    void deleteEmployeeByAccount_Login(String accountLogin);
}
