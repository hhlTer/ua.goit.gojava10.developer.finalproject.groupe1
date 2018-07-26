package factorymanagment.service.jpa;

import factorymanagment.model.domain.Status;
import factorymanagment.service.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Status getStatusById(long id){
        return statusRepository.getOne(id);
    }
}
