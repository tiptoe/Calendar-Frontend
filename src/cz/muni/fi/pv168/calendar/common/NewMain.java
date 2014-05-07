/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Cael
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Calendar c = new GregorianCalendar(2100, 12, 31, 23, 59);
       Date d = c.getTime();
       Long l = d.getTime();
       System.out.println(d);
       System.out.println(l);
       d.setTime(l);
       c.setTime(d);
       System.out.println(d);
       System.out.println(c.toString());
       
    }
}
