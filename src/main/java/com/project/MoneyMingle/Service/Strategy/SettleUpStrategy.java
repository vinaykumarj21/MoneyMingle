package com.project.MoneyMingle.Service.Strategy;

import com.project.MoneyMingle.DTO.TransactionDTO;
import com.project.MoneyMingle.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO>settleUp(List<Expense> expenses);
    //will return the TransactionDTO list
    //we will pass List<Expenses>-> to settleUp the transactions
}
