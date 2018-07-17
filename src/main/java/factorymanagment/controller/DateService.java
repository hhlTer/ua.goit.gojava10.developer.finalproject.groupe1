package factorymanagment.controller;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateService {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

    public Date formatStringToDate(String stringDate){
        try {
            return formatter.parse(stringDate);
        } catch (ParseException e) {
            System.out.println("wrong format, returned date: now");
            e.printStackTrace();
        }
        return new Date();
    }
}
