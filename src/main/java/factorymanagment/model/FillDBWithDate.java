package factorymanagment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Collections;


public class FillDBWithDate {

    private static String URL = "jdbc:mysql://localhost:3306/factorymanagment";
    private static String USER = "root";
    private static String PASSWORD = "admin12345";


    public static void main(String[] args) {
        initDBConnectionAndFillDB();
    }

    public static void initDBConnectionAndFillDB() {

        Connection connection = null;
        Statement statement = null;
        ArrayList<String> calender = buildCalender();
        Collections.sort(calender);

        try {
            connection = DriverManager
                    .getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            for (String day : calender) {
                statement.execute("insert into date_table(date_string_id) VALUES('" + day + "')");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    private static ArrayList<String> buildCalender() {

        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            result.addAll(buildDaysArrayForMonth(i));
        }

        return result;
    }

    private static ArrayList<String> buildDaysArrayForMonth(int month) {

        ArrayList<String> daysArray = new ArrayList<>();


        switch (month) {
            case 1:
                daysArray = buildDays(31, month);
                break;
            case 2:
                daysArray = buildDays(28, month);
                break;
            case 3:
                daysArray = buildDays(31, month);
                break;
            case 4:
                daysArray = buildDays(30, month);
                break;
            case 5:
                daysArray = buildDays(31, month);
                break;
            case 6:
                daysArray = buildDays(30, month);
                break;
            case 7:
                daysArray = buildDays(31, month);
                break;
            case 8:
                daysArray = buildDays(31, month);
                break;
            case 9:
                daysArray = buildDays(30, month);
                break;
            case 10:
                daysArray = buildDays(31, month);
                break;
            case 11:
                daysArray = buildDays(30, month);
                break;
            case 12:
                daysArray = buildDays(31, month);
                break;
            default:
                return daysArray;
        }

        return daysArray;
    }

    private static ArrayList<String> buildDays(int daysCount, int month) {

        ArrayList<String> daysArray = new ArrayList<>();

        for (int i = 1; i <= daysCount; i++) {
            if (i < 10 && month < 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(0).append(i).append("/").append(0).append(month).append("/").append("2018");
                daysArray.add(sb.toString());
            } else if (i < 10 && month >= 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(0).append(i).append("/").append(month).append("/").append("2018");
                daysArray.add(sb.toString());
            } else if (i >= 10 && month < 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append("/").append(0).append(month).append("/").append("2018");
                daysArray.add(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append("/").append(month).append("/").append("2018");
                daysArray.add(sb.toString());
            }
        }

        return daysArray;
    }
}
