package com.futurice.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateServiceTest {

    private DateService dateService;

    @BeforeEach
    void setup() {
        dateService = new DateService();
    }

    @Test
    void getDifference_whenDateOneGreaterThanDate2_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("2050-12-10");

        assertEquals(2, dateService.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDatesFromDifferentMonths_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("2050-11-12");

        assertEquals(30, dateService.getDifference(dateOne, dateTwo));
    }
    
    @Test
    void getDifference_whenOneYearGap_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("2051-12-12");

        assertEquals(365, dateService.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDatesFromDifferentYears_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("1000-11-12");

        assertEquals(383535, dateService.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenMaxPossibleRange_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("0001-01-01");
        LocalDate dateTwo = LocalDate.parse("9999-12-31");

        assertEquals(3652058, dateService.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDateOneLessThanThanDate2_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-10");
        LocalDate dateTwo = LocalDate.parse("2050-12-15");

        assertEquals(5, dateService.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDateOneEqualsToDate2_returnZero() {
        LocalDate dateOne = LocalDate.parse("2050-12-10");
        LocalDate dateTwo = LocalDate.parse("2050-12-10");

        assertEquals(0, dateService.getDifference(dateOne, dateTwo));
    }
}
