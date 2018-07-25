package factorymanagment.service.repository;

import factorymanagment.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>{

    @Query(nativeQuery = true,
    value = "select * from account left join account_role on account_id = account.id where account_role.role_id = :id")
    List<Account> findAllUsersByRoleId(@Param("id") long roleId);
    //TODO: security
}
