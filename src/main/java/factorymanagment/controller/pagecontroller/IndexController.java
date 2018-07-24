package factorymanagment.controller.pagecontroller;

import factorymanagment.model.domain.DateTable;
import factorymanagment.service.jpa.DateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private DateTableService dateTableService;

    @GetMapping("/")
    public ModelAndView mainPage(){

        temp();

        return new ModelAndView("index1");
    }

    private void temp(){
        List<DateTable> list =  dateTableService.getAll();
        list.stream()
                .map(d -> d.getDate())
                .forEach(System.out::println);
        dateTableService.saveAllNewDate();
    }
}
