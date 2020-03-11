package com.futurice.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@org.springframework.stereotype.Service
public class Service {
    public Integer getDifference(LocalDate dateOne, LocalDate dateTwo) {
        return Math.toIntExact(Math.abs(ChronoUnit.DAYS.between(dateOne, dateTwo)));
    }
}
