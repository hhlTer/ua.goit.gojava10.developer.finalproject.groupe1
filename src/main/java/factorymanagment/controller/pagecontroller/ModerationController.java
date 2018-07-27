package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Account;
import factorymanagment.model.domain.Employee;
import factorymanagment.model.domain.PassportData;
import factorymanagment.model.domain.WorkPosition;
import factorymanagment.service.jpa.EmployeeService;
import factorymanagment.service.jpa.PassportDataService;
import factorymanagment.service.jpa.WorkPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ModerationController extends MainController{
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PassportDataService passportDataService;

    @Autowired
    private WorkPositionService workPositionService;

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
            @RequestParam(required = false, defaultValue = "-1") long passportDataId,
            @RequestParam(required = false) String bornDateString,
            @ModelAttribute Account account,
            @ModelAttribute Employee employee,
            @ModelAttribute PassportData passportData,
            @ModelAttribute WorkPosition workPosition
    )

    {
        Date bornDate = normalizeDate(bornDateString);
        employee.setBornDate(bornDate);
        employee.setId(employeeId);
        employee.setAccount(account);
        employee.setPassportData(passportData);
        employee.setWorkPosition(workPosition);


        System.out.println(account.getAccount_id());
        System.out.println(passportData.getId());
        System.out.println(passportData.getPassportNumber());
        System.out.println(passportData.getTaxId());
        employeeService.save(employee);
        return "dashboard";
    }

    private Date normalizeDate(String bornDateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;
        try {
            result = format.parse(bornDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/deleteUser")
    void deleteEmployee(String accountLogin){
        employeeService.delete(accountLogin);
    }

}







