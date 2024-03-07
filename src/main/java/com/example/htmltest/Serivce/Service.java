package com.example.htmltest.Serivce;

@org.springframework.stereotype.Service
public class Service {

    public double bmi(double vægt, double højde){
            return vægt/(højde*højde);
    }

}
