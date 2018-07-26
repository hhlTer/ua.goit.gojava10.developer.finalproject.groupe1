package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Account;
import factorymanagment.model.domain.Employee;
import factorymanagment.model.domain.PassportData;
import factorymanagment.model.domain.WorkPosition;
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

    @GetMapping("/changeUser")
    public ModelAndView createPageShow(){
        ModelAndView modelAndView = securityModelGenerate("testRegisterEmployee");
        return modelAndView;
    }


    @PostMapping("/changeUser")
    public String createOrEditEmployee(
            @RequestParam(required = false, defaultValue = "-1") long employeeId,
            @ModelAttribute Employee employee,
//            @ModelAttribute Account account,
//            @ModelAttribute PassportData passportData,
            @ModelAttribute WorkPosition workPosition
    )

    {
        employee.setId(employeeId);
//        employee.setAccount(account);
//        employee.setPassportData(passportData);
//        employee.setWorkPosition(workPosition);
        employeeService.save(employee);
        return "dashboard";
    }

    @PostMapping("/deleteUser")
    void deleteEmployee(String accountLogin){
        employeeService.delete(accountLogin);
    }

}







