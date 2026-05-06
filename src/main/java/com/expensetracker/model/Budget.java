package com.expensetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Budget {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private double amount;

    public long getId(){ return id;}

    public double getAmount(){ return amount;}

    public void setAmount(double amount){ this.amount = amount;}


}
