package factorymanagment.service.repository;

import factorymanagment.model.domain.WorkHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {
    @Query(nativeQuery = true,
            value = "select sum(ws.hours)*e.salary_per_hour from event_schedule\n" +
                    "left join date_table on date_date_string_id = date_table.date_string_id\n" +
                    "left join status_schedule on status_schedule.date_date_string_id= event_schedule.date_date_string_id\n" +
                    "left join work_hours ws on work_hours_id = ws.id\n" +
                    "left join employee e on e.id = event_schedule.employee_id\n" +
                    "where event_schedule.employee_id = :eId\n" +
                    "and status_schedule.status_id = :st\n" +
                    "and date_table.date_string_id like :mn")
    long getSumSalaryByMonth(
            @Param("eId") long employeeId,
            @Param("mn") String month,
            @Param("st") long statusId
    );
}
