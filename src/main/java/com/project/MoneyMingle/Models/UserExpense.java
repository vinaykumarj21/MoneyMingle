package com.project.MoneyMingle.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MONEYMINGLE_USEREXPENSE")
public class UserExpense extends BaseClass{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;

}