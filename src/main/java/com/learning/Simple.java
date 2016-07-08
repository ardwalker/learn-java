package com.learning;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by andrew on 4/21/16.
 */
public class Simple
{
    public static void main(String[] args)
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.set(2015,5,1,0,0,0);


        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(expirationDate.getTime());
        calendarDate.add(Calendar.YEAR, 1);
        System.out.println(String.format("expire: %s, expunge: %s", expirationDate.getTime(), calendarDate.getTime()) );
    }
}
