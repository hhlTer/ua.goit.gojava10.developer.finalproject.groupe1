package factorymanagment.service.repository;

import factorymanagment.model.domain.EventSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventScheduleRepository extends JpaRepository<EventSchedule, String> {
    /**
     * **********************Valeriy
     * @param date
     * @param employee_id
     * @return
     */
    @Query(nativeQuery = true,
    value = "select * from event_schedule where date_date_string_id = :ds and employee_id = :id")
//    value = "SELECT from event_schedule es left join date_table dt on " +
//            "es.date_date_string_id = dt.date_string_id " +
//            "where d")
    EventSchedule getByDateAndEmployeeId(
            @Param("ds")String date,
            @Param("id") long employee_id);

}
