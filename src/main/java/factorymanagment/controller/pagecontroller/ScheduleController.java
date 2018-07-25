package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Employee;
import factorymanagment.service.jpa.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ScheduleController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("schedule");

        return modelAndView;
    }
}
