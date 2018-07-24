package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Employee;
import factorymanagment.service.jpa.DateTableService;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AboutController extends MainController{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DateTableService dateTableService;

    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = securityModelGenerate("about");

        dateTableService.saveAllNewDate();

        String username = getUserName();

        Employee employee = employeeService.getByUsername(username);
        System.out.println(employee.getFirstName());
        List<Employee> employeeList = employeeService.getAllEmpoloyee();

        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }
}
