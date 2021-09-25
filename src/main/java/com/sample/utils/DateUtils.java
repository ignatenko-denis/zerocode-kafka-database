package com.sample.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.mmm'Z'";

    public static String toDateTime(Object value) {
        Timestamp timestamp = (Timestamp) value;

        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        String format;
        if (localDateTime.getHour() == 0 && localDateTime.getMinute() == 0
                && localDateTime.getSecond() == 0 && localDateTime.getNano() == 0) {
            format = DATE_FORMAT;
        } else {
            format = DATE_TIME_FORMAT;
        }

        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(timestamp);
    }
}