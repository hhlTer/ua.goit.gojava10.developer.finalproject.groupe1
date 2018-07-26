package factorymanagment.service.repository;

import factorymanagment.model.domain.StatusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusScheduleRepository extends JpaRepository<StatusSchedule, Long> {

    @Query(nativeQuery = true,
    value = "select * from status_schedule where date_date_string_id = :ds and employee_id = :id")
    StatusSchedule getByDateAndEmployeeId(
            @Param("ds")String date,
            @Param("id") long employee_id);
}
