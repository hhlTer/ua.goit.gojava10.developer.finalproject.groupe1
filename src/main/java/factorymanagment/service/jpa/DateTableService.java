package factorymanagment.service.jpa;

import factorymanagment.model.domain.DateTable;
import factorymanagment.service.repository.DateTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class DateTableService {
    @Autowired
    private DateTableRepository dateTableRepository;

    public List<DateTable> getAll(){
        return dateTableRepository.findAll();
    }

    public void save(DateTable dateTable) {
        if (null != dateTable) {
            dateTableRepository.save(dateTable);
        }
    }

    public void saveAllNewDate() {
        Set<DateTable> dateTableSet = dateTableRepository.getAllByDateNull();
        dateTableSet
                .forEach(d -> d.setDate(d.getDateId()));

        dateTableRepository.saveAll(dateTableSet);
    }
}
