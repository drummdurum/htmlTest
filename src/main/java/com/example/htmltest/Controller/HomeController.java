package com.example.htmltest.Controller;
import com.example.htmltest.Serivce.DayCalculator;
import com.example.htmltest.Serivce.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.time.DayOfWeek;

@Controller
public class HomeController {

    @Autowired
    public DayCalculator dayCalculator;

    @GetMapping("/tjekDagen")
    public String isItFriday(){
     return "tjekDagen";
    }

    @PostMapping("/tjekDagen")
    public DayOfWeek udregnUgeDag(@RequestParam("day")DayOfWeek day){
        DayOfWeek udregn = DayOfWeek.valueOf(dayCalculator.whatDayIsIt(day));
        return udregn;
    }

    @Autowired
    public Service service;

    @GetMapping("/BMI")
    public String BMI(){
    return"BMI";
    }

    @PostMapping("/BMI")
    public String BMIudregn(@RequestParam("vægt") double vægt, @RequestParam("højde") double højde, RedirectAttributes redirectAttributes) {
        double bmi = service.bmi(vægt, højde);
        redirectAttributes.addAttribute("bmi", bmi);
        return"redirect:/BMIResult";
    }

    @GetMapping("/BMIResult")
    public String showResult(@RequestParam("bmi") double bmi, Model model){
        model.addAttribute("bmi", bmi);
        return "BMIResult";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/Terminator")
    public String ter(){
        return "Terminator";
    }

    @GetMapping("/BT")
    public String BT(){
        return "BT";
    }

    @GetMapping("/nyheder")
    public String nyheder(){return "nyheder";}

}
