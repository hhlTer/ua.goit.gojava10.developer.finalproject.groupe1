package factorymanagment.controller.pagecontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ScheduleController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/schedule")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("schedule");

        return modelAndView;
    }
}
