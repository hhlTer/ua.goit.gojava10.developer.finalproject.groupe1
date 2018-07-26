package factorymanagment.service.jpa;

import factorymanagment.model.domain.Event;
import factorymanagment.service.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event getEventById(long id){
        return eventRepository.getOne(id);
    }
}
