package factorymanagment.service.jpa;

import factorymanagment.model.domain.DateTable;
import factorymanagment.service.repository.DateTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DateTableService {
    @Autowired
    private DateTableRepository dateTableRepository;

    public List<DateTable> getAll(){
        return dateTableRepository.findAll();
    }
}
