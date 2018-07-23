package factorymanagment.service.repository;

import factorymanagment.model.domain.DateTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DateTableRepository extends JpaRepository<DateTable, String>{

}