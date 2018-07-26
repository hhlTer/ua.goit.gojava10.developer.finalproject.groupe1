package factorymanagment.service.jpa;

import factorymanagment.model.domain.DateTable;
import factorymanagment.model.secondDomain.Period;
import factorymanagment.service.repository.DateTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class DateTableService {
    @Autowired
    private DateTableRepository dateTableRepository;

    /**
     *
     * **********************Valeriy*****************************
     * @return
     */
    public List<DateTable> getAll(){
        return dateTableRepository.findAll();
    }

    /**
     *
     * **********************Valeriy*****************************
     * @param dateTable
     */

    public void save(DateTable dateTable) {
        if (null != dateTable) {
            dateTableRepository.save(dateTable);
        }
    }

    /**
     *
     * **********************Valeriy*****************************
     */

    public void saveAllNewDate() {
        Set<DateTable> dateTableSet = dateTableRepository.getAllByDateNull();
        dateTableSet
                .forEach(d -> d.setDate(d.getDateId()));

        dateTableRepository.saveAll(dateTableSet);
    }

    /**
     *
     * **********************Valeriy*****************************
     * return DateTable cortege (if exist)
     * if empty - try create cortege and return
     * @param stringDate must be format "dd/MM/yyyy"
     * @return
     */
    public DateTable getDateTableByStringId(String stringDate){
        DateTable result = null;
        if (dateTableRepository.existsById(stringDate)){
            result = dateTableRepository.getOne(stringDate);
            result.getDate(); //fill if result.getDate() == null
        } else {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = format.parse(stringDate);
                result = new DateTable();
                result.setDate(stringDate);
                result.setDateId(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * **********************Valeriy*****************************
     * return DateTable by Date
     * parse date and use getDateTableByStringId(String sId)
     * @param date
     * @return
     */
    public DateTable getByDate(Date date){
        DateTable result = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String ds = format.format(date);
        return getDateTableByStringId(ds);
    }

    /**
     *
     * **********************Valeriy*****************************
     * get arraylist of date from
     * @param period
     * @return
     */
    public List<DateTable> getByPeriod(Period period) {
        return dateTableRepository.getAllByDateBetween(period.getFromDate(), period.getToDate());
    }
}
