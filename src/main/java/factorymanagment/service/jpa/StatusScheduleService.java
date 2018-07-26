package factorymanagment.service.jpa;

import factorymanagment.model.domain.StatusSchedule;
import factorymanagment.service.repository.StatusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusScheduleService {

    @Autowired
    private StatusScheduleRepository statusScheduleRepository;

    @Autowired
    private StatusService statusService;
    /**
     * ***********************Valeriy
     * @param dateId
     * @param employeeId
     * @return
     */
    public StatusSchedule getStatusByDateAndEmployeeId(String dateId, long employeeId) {
        return statusScheduleRepository.getByDateAndEmployeeId(dateId, employeeId);
    }
}
