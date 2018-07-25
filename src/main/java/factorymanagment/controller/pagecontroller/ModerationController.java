package factorymanagment.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModerationController extends MainController{
//    @Autowired
//    private EmployeeService employeeService;

    @GetMapping("/moderation")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = securityModelGenerate("moderation");

        return modelAndView;
    }
}
