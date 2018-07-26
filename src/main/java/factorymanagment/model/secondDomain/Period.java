package factorymanagment.model.secondDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Period {

    private Date fromDate;
    private Date toDate;
    private String stringFromDate;
    private String stringToDate;

    public Period(){};
    public Period(String stringFromDate, String stringToDate){
        setStringFromDate(stringFromDate);
        setStringToDate(stringToDate);
    }
    private final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Date getFromDate() {
        if (fromDate != null) {
            return fromDate;
        }

        if (stringFromDate == null){
            return null;
        }

        if (!stringFromDate.matches("dd/MM/yyyy")){
            return null;
        }

        try {
            this.fromDate = FORMAT.parse(stringFromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.stringFromDate = FORMAT.format(fromDate);
        try {
            this.fromDate = FORMAT.parse(stringFromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getToDate() {
        if (this.toDate != null){
            return this.toDate;
        }

        if (this.stringToDate == null){
            return null;
        }

        if (!stringToDate.matches("dd/MM/yyyy")){
            return null;
        }

        try {
            this.toDate = FORMAT.parse(this.stringToDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.stringToDate = FORMAT.format(toDate);
        try {
            this.toDate = FORMAT.parse(this.stringToDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getStringFromDate() {
        if (this.stringFromDate != null){
            return stringFromDate;
        }

        if (this.fromDate == null){
            return null;
        }

        return FORMAT.format(this.fromDate);
    }

    public void setStringFromDate(String stringFromDate) {
        try {
            this.fromDate = FORMAT.parse(stringFromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.stringFromDate = stringFromDate;
    }

    public String getStringToDate() {
        if (this.stringToDate != null){
            return stringToDate;
        }

        if (this.toDate == null){
            return null;
        }

        return FORMAT.format(this.toDate);
    }

    public void setStringToDate(String stringToDate) {
        try {
            this.toDate = FORMAT.parse(stringToDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.stringToDate = stringToDate;
    }
}
