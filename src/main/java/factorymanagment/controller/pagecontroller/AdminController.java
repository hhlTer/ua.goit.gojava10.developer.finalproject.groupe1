package factorymanagment.controller.pagecontroller;

import factorymanagment.model.secondDomain.CalendarToOut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends MainController{

    @GetMapping("/admin/schedule/edit")
    public ModelAndView showEditLine(
            @RequestParam long employeeId,
            @ModelAttribute CalendarToOut scheduleLine
            ){
        ModelAndView modelAndView = securityModelGenerate("editline");
        modelAndView.addObject("employeeId", employeeId);
        modelAndView.addObject("scheduleLine", scheduleLine);
        return modelAndView;
    }

    @PostMapping("/admin/schedule/edit")
    public String editLine(
            @RequestParam long employeeId,
            @ModelAttribute CalendarToOut scheduleLine
    ){
        return ":/redirect";
    }
}
