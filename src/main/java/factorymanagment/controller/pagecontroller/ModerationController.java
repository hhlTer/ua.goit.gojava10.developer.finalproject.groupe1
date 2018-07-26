package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Employee;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModerationController extends MainController{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/moderation")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("moderation");

        return modelAndView;
    }

    @PostMapping("/changeUser")
    public Employee createOrEditEmployee(@RequestParam int employeeId,
              @ModelAttribute Employee employee){
        employee.setId(employeeId);
        return employeeService.save(employee);
    }

    @PostMapping("/deleteUser")
    void deleteEmployee(String accountLogin){
        employeeService.delete(accountLogin);
    }

}







