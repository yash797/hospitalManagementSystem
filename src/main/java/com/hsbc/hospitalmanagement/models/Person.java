package com.hsbc.hospitalmanagement.models;

import lombok.AllArgsConstructor;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Component
public class Person  {
    private long personId;
    private FullName name;
    private LocalDate dob;
}