package factorymanagment.controller.pagecontroller;


import factorymanagment.model.domain.DateTable;
import factorymanagment.model.domain.Employee;
import factorymanagment.model.secondDomain.CalendarToOut;
import factorymanagment.model.secondDomain.Period;
import factorymanagment.service.adittionalmodelservice.CalendarToOutService;
import factorymanagment.service.jpa.DateTableService;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class ScheduleController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private DateTableService dateTableService;

    @Autowired
    private CalendarToOutService calendarToOutService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView mainPage(
            @RequestParam(required = false, defaultValue = "-1") long employeeId,
            @RequestParam(required = false, defaultValue = "-1") int month,
            @RequestParam(required = false, defaultValue = "-1") int year
    ) {
        ModelAndView modelAndView = securityModelGenerate("calendarForEmployee");
        Period period = getPeriod(month, year);

        if (employeeId == -1){
            Employee employee = employeeService.getByAccountUserName(getUserName());
            employeeId = employee.getId();
        }


        /**
         * get only exists date in date table from current year;
         */
        List<DateTable> dateList = dateTableService.getByPeriod(period);
        HashMap<Date, CalendarToOut> calendarMap = calendarToOutService.getCalendarToOut(period, employeeId);

        sysoutCalendar(dateList, calendarMap);

        modelAndView.addObject("employeeId", employeeId);
        modelAndView.addObject("month", month);
        modelAndView.addObject("year", year);
        modelAndView.addObject("dateList", dateList);
        modelAndView.addObject("schedule", calendarMap);
        return modelAndView;
    }

    private Period getPeriod(int month, int year) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int m = month == -1 ? calendar.get(Calendar.MONTH) : month;
        int y = year == -1 ? calendar.get(Calendar.YEAR) : year;
        date.setMonth(m);
        date.setYear(y);
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String fromDate = dateStringGenerate(1, m, y);
        String toDate = dateStringGenerate(lastDay, m, y);
        return new Period(fromDate, toDate);
    }

    private String dateStringGenerate(int d, int m, int y) {
        return String.format("%d/%d/%d", d, m, y);
    }

    private long detectMonth() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    private void sysoutCalendar(List<DateTable> dateList, HashMap<Date, CalendarToOut> calendarToOutHashMap) {
        for (DateTable dt:
                dateList) {
            if (null != dt.getDateId()){
                if (null != calendarToOutHashMap.get(dt.getDate()))
                    System.out.println(dt.getDateId() + ": " + calendarToOutHashMap.get(dt.getDate()).getEvent().getEventName());
                    System.out.println(dt.getDateId() + ": " + calendarToOutHashMap.get(dt.getDate()).getWorkHours().getStartTime());
                    System.out.println(dt.getDateId() + ": " + calendarToOutHashMap.get(dt.getDate()).getWorkHours().getFinishTime());
            }
        }
    }

    private Period getCurrentYear() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year, Calendar.JANUARY, 1);
        String fromDate = "01/01/" + year;
        String toDate = "31/12/" + year;
        return new Period(fromDate, toDate);
    }
}
