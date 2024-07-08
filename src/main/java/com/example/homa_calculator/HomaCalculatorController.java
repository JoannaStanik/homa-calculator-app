package com.example.homa_calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomaCalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateHoma(
            @RequestParam("glucose") double glucose,
            @RequestParam("insulin") double insulin,
            Model model) {

        double homaIr = (glucose * insulin) / 405;
        model.addAttribute("homaIr", homaIr);

        return "result";
    }
}
