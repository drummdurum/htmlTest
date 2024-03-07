package com.example.htmltest.Serivce;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class DayCalculator {

    public String whatDayIsIt(DayOfWeek day){
        if(day == DayOfWeek.FRIDAY){
            return "det er fredag!";
        }
        else return "det er ikke fredag";
    }



}
