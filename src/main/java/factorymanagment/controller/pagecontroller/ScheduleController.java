package factorymanagment.controller.pagecontroller;


import factorymanagment.model.domain.DateTable;
import factorymanagment.model.secondDomain.CalendarToOut;
import factorymanagment.model.secondDomain.Period;
import factorymanagment.service.adittionalmodelservice.CalendarToOutService;
import factorymanagment.service.jpa.DateTableService;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


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
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("schedule");


        Period period = new Period("01/07/2018", "20/07/2018");

        List<DateTable> dateList = dateTableService.getByPeriod(period);
        HashMap<Date, CalendarToOut> calendarToOutHashMap = calendarToOutService.getCalendarToOut(period, 1);

        for (DateTable dt:
                dateList) {
            if (null != dt.getDateId()){
                if (null != calendarToOutHashMap.get(dt.getDate()))
                    System.out.println(dt.getDateId() + ": " + calendarToOutHashMap.get(dt.getDate()).getEvent());
            }
        }
        return modelAndView;
    }
}
