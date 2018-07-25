package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControllerForDmitroAndVeleryi extends MainController {

    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = securityModelGenerate("testForDmitroAndValeryi");

        Account account = new Account();
        account.setLogin("testlogin");
        modelAndView.addObject("ttrr", account);
        return modelAndView;
    }
}
