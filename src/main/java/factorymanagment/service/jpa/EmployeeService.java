package factorymanagment.service.jpa;

import factorymanagment.model.domain.Employee;
import factorymanagment.model.domain.Event;
import factorymanagment.model.domain.Status;
import factorymanagment.service.repository.EmployeeRepository;
import factorymanagment.service.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Employee> getAllEmpoloyee(){
        return employeeRepository.findAll();
    }

    public Employee getByUsername(String username) {
        return employeeRepository.getByAccount_Login(username);
    }


    /**
     * return all employees who have
     * @param event
     * in period
     * @param fromDate - string format
     * @param toDate - string format
     * @return getAllWhoUnEventInPeriod(Event, Date, Date)
     */
    public List<Employee> getAllWhoInEventInPeriod(Event event, String fromDate, String toDate){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDateFrom = null;
        Date dateDateTo = null;
        try {
            dateDateFrom = format.parse(fromDate);
            dateDateTo = format.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getAllWhoInEventInPeriod(event, dateDateFrom, dateDateTo);
    }

    /**
     * return by Date format
     * @param event
     * @param fromDate - Date format
     * @param toDate
     * @return
     */
    public List<Employee> getAllWhoInEventInPeriod(Event event, Date fromDate, Date toDate){
        return employeeRepository.getAllWhoInEventInPeriod(event.getEventId(), fromDate, toDate);
    }

    public List<Employee> getAllEmployeesFromPeriodWhoHaveStatus(Status status, Date fromDate, Date toDate){
        return employeeRepository.getAllByStatusScheduleSetBetweenAndStatusScheduleSet(fromDate, toDate,status.getId());
//        return employeeRepository.getAllEmployeesFromPeriodWhoHaveStatus(status.getId(), fromDate, toDate);
    }

    public Employee save(Employee employee){
       return employeeRepository.save(employee);
    }

    public void delete(String accountLogin) {
        employeeRepository.deleteEmployeeByAccount_Login(accountLogin);
    }
}
