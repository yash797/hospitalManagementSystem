package com.hsbc.hospitalmanagement.controllers;

import com.hsbc.hospitalmanagement.dtos.EmployeeRequest;
import com.hsbc.hospitalmanagement.services.CountryService;
import com.hsbc.hospitalmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SignUpController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/signup")
    public String loadSignUp(Model model) {
        List<String> countries = countryService.getCountryNames();
        model.addAttribute("countries", countries);
        model.addAttribute("employeeRequest", new EmployeeRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignUp(@ModelAttribute("employeeRequest") EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
        return "redirect:/signin";
    }
}