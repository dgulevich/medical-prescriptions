package com.it.app.component;

import org.dozer.DozerConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends DozerConverter<Date, String> {

    public DateConverter() {
        super(Date.class, String.class);
    }

    @Override
    public String convertTo(Date date, String s) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return s = format.format(date);
    }

    @Override
    public Date convertFrom(String s, Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return date = format.parse(s);
        } catch (ParseException e) {
            new RuntimeException("Date is not valid");
        }
        return date;
    }
}
