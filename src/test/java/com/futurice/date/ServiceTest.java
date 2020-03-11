package com.futurice.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    private Service service;

    @BeforeEach
    void setup() {
        service = new Service();
    }

    @Test
    void getDifference_whenDateOneGreaterThanDate2_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("2050-12-10");

        assertEquals(2, service.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDatesFromDifferentMonths_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("2050-11-12");

        assertEquals(30, service.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDatesFromDifferentYears_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-12");
        LocalDate dateTwo = LocalDate.parse("1000-11-12");

        assertEquals(383535, service.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDateOneLessThanThanDate2_returnPositiveDifference() {
        LocalDate dateOne = LocalDate.parse("2050-12-10");
        LocalDate dateTwo = LocalDate.parse("2050-12-15");

        assertEquals(5, service.getDifference(dateOne, dateTwo));
    }

    @Test
    void getDifference_whenDateOneEqualsToDate2_returnZero() {
        LocalDate dateOne = LocalDate.parse("2050-12-10");
        LocalDate dateTwo = LocalDate.parse("2050-12-10");

        assertEquals(0, service.getDifference(dateOne, dateTwo));
    }
}