package factorymanagment.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/dashboard")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("dashboard");

        return modelAndView;
    }
}
