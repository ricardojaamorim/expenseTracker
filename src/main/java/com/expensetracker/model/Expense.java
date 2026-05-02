package com.expensetracker.model;

import lombok.Data;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Expense {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            public Long id;

    String title;
    String category;
    double amount;
    LocalDate date;

}
