package com.example.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CreditAccount extends Account{

    private BigDecimal creditLimit;

}
