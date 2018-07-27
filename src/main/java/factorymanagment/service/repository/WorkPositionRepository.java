package factorymanagment.service.repository;

import factorymanagment.model.domain.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPositionRepository extends JpaRepository<WorkPosition, Long> {
}
