package factorymanagment.service.repository;

import factorymanagment.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
    //TODO: security
}
