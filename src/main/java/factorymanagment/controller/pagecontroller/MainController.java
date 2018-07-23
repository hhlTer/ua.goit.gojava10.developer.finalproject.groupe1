package factorymanagment.controller.pagecontroller;

import factorymanagment.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private SecurityService securityService;

    ModelAndView securityModelGenerate(String uri){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return securityService.getSecurityModel(uri, authentication);
    }

    String getUserName(){
        return securityService.getUsername();
    }
}
