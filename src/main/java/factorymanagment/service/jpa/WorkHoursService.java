package factorymanagment.service.jpa;


import factorymanagment.service.repository.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkHoursService {

    @Autowired
    WorkHoursRepository workHoursRepository;

    public long getSumSalaryOfEmployee(long eId, String month, Long statusId){
        return workHoursRepository.getSumSalaryByMonth(eId,month,statusId);
    }
}
