package Kiwee.utils;

import Kiwee.exception.WrongDateFormatException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility class for parsing and formatting dates.
 */
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

    /**
     * Returns a LocalDateTime parsed from a date/time string.
     * For time-only input, uses today's date.
     *
     * @param date The date string to parse
     * @return A LocalDateTime object representing the parsed date
     * @throws WrongDateFormatException If the date format is not recognized
     */
    public static LocalDateTime parseDate(String date) throws WrongDateFormatException {
        if (date == null || date.isEmpty()) {
            throw new WrongDateFormatException();
        }

        for (String pattern : DATE_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            try {
                return LocalDate.parse(date, formatter).atStartOfDay();
            } catch (DateTimeParseException ignored) {
                // Intentionally ignore and try the next pattern
            }
        }

        for (String pattern : DATE_TIME_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            try {
                return LocalDateTime.parse(date, formatter);
            } catch (DateTimeParseException ignored) {
                // Intentionally ignore and try the next pattern
            }
        }

        for (String pattern : TIME_PATTERNS) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            try {
                LocalTime time = LocalTime.parse(date, formatter);
                return LocalDate.now().atTime(time);
            } catch (DateTimeParseException ignored) {
                // Intentionally ignore and try the next pattern
            }
        }

        throw new WrongDateFormatException();
    }

    /**
     * Returns a human-readable representation of LocalDateTime.
     *
     * @param date The LocalDateTime to format
     * @return A formatted date string in "MMM dd yyyy, h:mma" format
     */
    public static String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");
        return date.format(formatter);
    }
}
