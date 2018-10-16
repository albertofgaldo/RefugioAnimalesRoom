package com.animal.refugio.refugioanimales.utilities;

import android.arch.persistence.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTypeConverter {

    String dateFormat = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);

    @TypeConverter
    public static String toString(Long value) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date(value);

        return f.format(d);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}