package com.futurice.date;

import java.time.LocalDate;
import java.time.Period;

@org.springframework.stereotype.Service
public class Service {
    public Integer getDifference(LocalDate dateOne, LocalDate dateTwo) {
        return Math.abs(Period.between(dateOne, dateTwo).getDays());
    }
}
