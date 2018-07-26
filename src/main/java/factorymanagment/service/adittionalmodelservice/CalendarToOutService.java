package factorymanagment.service.adittionalmodelservice;

import factorymanagment.model.domain.*;
import factorymanagment.model.secondDomain.CalendarToOut;
import factorymanagment.model.secondDomain.Period;
import factorymanagment.service.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * *******Valeryi
 */
@Service
public class CalendarToOutService {

    @Autowired
    private DateTableService dateTableService;

    @Autowired
    private EventScheduleService eventScheduleService;

    @Autowired
    private StatusScheduleService statusScheduleService;

    public HashMap<Date, CalendarToOut> getCalendarToOut(Period period, long employeeId){
        List<DateTable> dateList = dateTableService.getByPeriod(period);

        HashMap<Date, CalendarToOut> result = new HashMap<>(dateList.size());
        for (DateTable dt:
             dateList) {
            CalendarToOut cto = new CalendarToOut();

            EventSchedule eventSchedule = eventScheduleService.getEventByDateAndEmployeeId(dt.getDateId(), employeeId);
            Event event = null;
            WorkHours workHours = null;
            if (null != eventSchedule){
                event = eventSchedule.getEvent();
                workHours = eventSchedule.getWorkHours();
            }
            cto.setEvent(event);
            cto.setWorkHours(workHours);

            StatusSchedule statusSchedule = statusScheduleService.getStatusByDateAndEmployeeId(dt.getDateId(), employeeId);
            Status status = null;
            if (null != statusSchedule){
                status = statusSchedule.getStatus();
            }
            cto.setStatus(status);
            result.put(dt.getDate(), cto);
        }
    return result;
    }
}
