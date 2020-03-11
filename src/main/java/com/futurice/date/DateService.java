package com.futurice.date;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DateService {
    public Integer getDifference(LocalDate dateOne, LocalDate dateTwo) {
        return Math.toIntExact(Math.abs(ChronoUnit.DAYS.between(dateOne, dateTwo)));
    }
}
