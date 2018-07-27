package factorymanagment.controller;

import org.springframework.scheduling.annotation.Scheduled;

public class SalarayController {

    //second, minute, hour, day of month, month, day(s) of week
    @Scheduled(cron = "0 0 0 1 * ? *")
    void countSalaryForMonth(){

    }
}
