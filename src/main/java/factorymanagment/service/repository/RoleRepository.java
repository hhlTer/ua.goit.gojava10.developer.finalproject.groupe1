package factorymanagment.service.repository;

import factorymanagment.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(nativeQuery = true, value = "select * from role where role_name = :rol")
    Role getByRole(@Param("rol") String role);
}
