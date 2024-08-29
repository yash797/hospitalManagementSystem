package com.hsbc.hospitalmanagement.controllers;

import com.hsbc.hospitalmanagement.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SignInController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/signin")
    public String loadSignUp(Model model) {
        List<String> countries = countryService.getCountryNames();
        model.addAttribute("countries", countries);
        return "signIn.html";
    }
}