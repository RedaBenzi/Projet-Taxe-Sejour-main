package com.example.demo.service.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class DateUtil {


    public static LocalDateTime constructLocalDateTime(int trimestre, int annee) {
        LocalDateTime dateTime;
        if (trimestre == 1) {
            dateTime = LocalDateTime.of(annee, Month.MARCH, 31, 0, 0);
        } else if (trimestre == 2) {
            dateTime = LocalDateTime.of(annee, Month.JUNE, 30, 0, 0);
        } else if (trimestre == 3) {
            dateTime = LocalDateTime.of(annee, Month.SEPTEMBER, 30, 0, 0);
        } else {
            dateTime = LocalDateTime.of(annee, Month.DECEMBER, 31, 0, 0);
        }
        return dateTime;
    }


    public static int calculateNbrMoisRetard(int trimestre, int annee, LocalDateTime datePresentation) {
        LocalDateTime localDateTime = DateUtil.constructLocalDateTime(trimestre,  annee);
        long between = ChronoUnit.MONTHS.between(datePresentation, localDateTime);
        return between < 0 ? 0 : (int) between;
    }
}
