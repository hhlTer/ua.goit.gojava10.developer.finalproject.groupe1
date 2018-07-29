package factorymanagment.controller;

import factorymanagment.service.jpa.WorkHoursService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;


public class SalarayController {

    WorkHoursService workHoursService;

    //second, minute, hour, day of month, month, day(s) of week
    @Scheduled(cron = "0 1 0 1 * ? *")
    long countSalaryForMonth(long employeeId, long statusId){

        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();

        StringBuilder sb = new StringBuilder();
        sb.append("%").append(month).append("/").append(year);
        String currentDate = sb.toString();

        return workHoursService.getSumSalaryOfEmployee(employeeId,currentDate,statusId);
    }
}
