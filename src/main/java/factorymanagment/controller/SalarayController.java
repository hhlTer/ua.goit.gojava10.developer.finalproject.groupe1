package factorymanagment.controller;

import factorymanagment.service.jpa.EmployeeService;
import factorymanagment.service.jpa.StatusService;
import factorymanagment.service.jpa.WorkHoursService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;



public class SalarayController {

    WorkHoursService workHoursService;
//    EmployeeService employeeService;
//    StatusService statusService;

    //second, minute, hour, day of month, month, day(s) of week
    @Scheduled(cron = "0 1 0 1 * ? *")
    public long countSalaryForMonth(long employeeId, long statusId) {

        int month = LocalDateTime.now().getMonthValue() - 1;
        int year = LocalDateTime.now().getYear();

        StringBuilder sb = new StringBuilder();
        sb.append("%").append(month).append("/").append(year);
        String currentDate = sb.toString();

        return workHoursService.getSumSalaryOfEmployee(employeeId, currentDate, statusId);
    }

    // по хорошему нужно создать еще одну таблицу с зарплатами за месяц и считать каждый месяц зарплату для всех рабочих-1
    //потом сохранять результат в созданную таблицу формировать смету за месяц и отправлять рабочему на мейл
    // @Scheduled(cron = "0 1 0 1 * ? *")
    // public void countSalaryForAllEmployee(){
    //    ArrayList<Employee> employeeArrayList = (ArrayList<Employee>) employeeService.getAllEmpoloyee();
    //     employeeArrayList.forEach(employee -> saveSalary(countSalaryForMonth(employee.getId(),statusService.getStatusById(2).getId())));
    // }
}
