package factorymanagment.service.jpa;

import factorymanagment.model.domain.EventSchedule;
import factorymanagment.service.repository.EventScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class EventScheduleService {

    @Autowired
    private EventScheduleRepository eventScheduleRepository;

    @Query
    public EventSchedule getEventByDateAndEmployeeId(String dateId, long employeeId) {
        return eventScheduleRepository.getByDateAndEmployeeId(dateId, employeeId);
    }
}
