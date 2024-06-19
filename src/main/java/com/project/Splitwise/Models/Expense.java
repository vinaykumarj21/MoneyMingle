package com.project.Splitwise.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseClass{
    private double Amount;
    private String Description;//who paid , who had to pay

    @Enumerated(EnumType.STRING)//to store enum values as String & @Enumerated(EnumType.Ordinal)->as Integers
    private Currency currency;

    @OneToMany
    @JoinColumn(name = "splitwise_expense_id")
    private List<UserExpense> userExpenses;
}
//Expense -> currency -> 1:1