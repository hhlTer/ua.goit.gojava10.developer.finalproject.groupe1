package factorymanagment.service.jpa;

import factorymanagment.model.domain.WorkPosition;
import factorymanagment.service.repository.WorkPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkPositionService {
    @Autowired
    private WorkPositionRepository workPositionRepository;

    public WorkPosition save(WorkPosition workPosition){
        return workPositionRepository.save(workPosition);
    }
}
