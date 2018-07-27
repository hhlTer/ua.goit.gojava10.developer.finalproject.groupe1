package factorymanagment.service.repository;

import factorymanagment.model.domain.PassportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportDataRepository extends JpaRepository<PassportData, Long> {
}
