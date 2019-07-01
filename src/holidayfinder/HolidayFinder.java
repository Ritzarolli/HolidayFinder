/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidayfinder;

import com.holidaywebservice.holidayservice_v2.*;
import java.util.*;

/**
 *
 * @author mnhammond0
 * @version 2019.06.30
 */
public class HolidayFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GetCountriesAvailable country = new GetCountriesAvailable();
        
        Scanner prompt = new Scanner(System.in);
        System.out.println("This program lists to calendar date for every holiday in a given year.");
        System.out.println("Please enter a year (ex. 2021).");
        int year = prompt.nextInt();
        
        int length = String.valueOf(year).length();
        
        if (length != 4) {
            System.out.println("Please enter a valid year (ex. 2021)");
        }
        else {
            HolidayService2 holidays = new HolidayService2();
            HolidayService2Soap holidaySoap = holidays.getHolidayService2Soap();
            ArrayOfHoliday arrayOfHoliday = holidaySoap.getHolidaysForYear(Country.UNITED_STATES, year);
            List<Holiday> holidayList = arrayOfHoliday.getHoliday();
            System.out.println(holidayList.toString());
        }
        
    }
    
}
