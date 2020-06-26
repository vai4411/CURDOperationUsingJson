package com.bl.crudoperation.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeFormatUtil {

    public static String currentDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }
}
