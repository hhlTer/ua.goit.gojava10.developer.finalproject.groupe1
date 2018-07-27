package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Account;
import factorymanagment.model.domain.Employee;
import factorymanagment.service.jpa.AccountService;
import factorymanagment.service.jpa.DateTableService;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DateTableService dateTableService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/dashboard")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("dashboard");

        dateTableService.saveAllNewDate();

        List<Account> accounts = accountService.findAllAccountWithRole("USER");
        accounts.stream().map(s -> s.getLogin()).forEach(System.out::println);

        String username = getUserName();

        Employee employee = employeeService.getByAccountUserName(username);
        System.out.println(employee.getFirstName());
        List<Employee> employeeList = employeeService.getAllEmpoloyee();

        modelAndView.addObject("employees", employeeList);

        return modelAndView;
    }
}
