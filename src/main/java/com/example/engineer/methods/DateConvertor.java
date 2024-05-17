package com.example.engineer.methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConvertor {

    public static LocalDate ConvertDate(String dateToParse)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDate.parse(dateToParse, formatter);
    }
}
