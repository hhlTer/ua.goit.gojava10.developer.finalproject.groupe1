package factorymanagment.service.jpa;

import factorymanagment.model.domain.Account;
import factorymanagment.model.domain.Role;
import factorymanagment.service.repository.AccountRepository;
import factorymanagment.service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public List<Account> findAllAccountWithRole(String role){
        Role role1 = roleRepository.getByRole(role);
        if (null == role1){
            throw  new NullPointerException("handler null pointer exception");
        }

        return accountRepository.findAllUsersByRoleId(role1.getRoleId());
    }
}
