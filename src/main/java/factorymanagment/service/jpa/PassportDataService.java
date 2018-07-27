package factorymanagment.service.jpa;

import factorymanagment.model.domain.PassportData;
import factorymanagment.service.repository.PassportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportDataService {
    @Autowired
    private PassportDataRepository passportDataRepository;

    public PassportData save(PassportData passportData){
        return passportDataRepository.save(passportData);
    }
}
