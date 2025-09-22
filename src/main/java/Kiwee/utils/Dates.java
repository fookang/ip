package Kiwee.utils;

import Kiwee.exception.KiweeException;
import Kiwee.exception.WrongDateFormatException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Dates {

    private static final String[] DATE_PATTERNS = {
            "yyyy-MM-dd", "d/M/yyyy", "d-M-yyyy"
    };

    private static final String[] DATE_TIME_PATTERNS = {
            "yyyy-MM-dd HH:mm", "d/M/yyyy HHmm", "d/M/yyyy HH:mm",
            "d-M-yyyy HHmm", "d-M-yyyy HH:mm", "yyyy-MM-dd'T'HH:mm"
    };

    private static final String[] TIME_PATTERNS = {
            "HH:mm", "HHmm", "h:mma"
    };

    public static LocalDateTime parseDate(String date) throws KiweeException {
        if (date == null || date.isEmpty()) {
            throw new KiweeException("Date cannot be empty");
        }

        for (String pattern : DATE_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            try {
                return LocalDate.parse(date, formatter).atStartOfDay();
            } catch (DateTimeParseException e) {
            }
        }

        for (String pattern : DATE_TIME_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            try {
                return LocalDateTime.parse(date, formatter);
            } catch (DateTimeParseException e) {
            }
        }

        for (String pattern : TIME_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            try {
                LocalTime time = LocalTime.parse(date, formatter);
                return LocalDate.now().atTime(time);
            } catch (DateTimeParseException e) {
            }
        }

        throw new WrongDateFormatException();
    }

    public static String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");
        return date.format(formatter);
    }
}
