package com.project.Splitwise.Service.Strategy;

import com.project.Splitwise.DTO.TransactionDTO;
import com.project.Splitwise.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO>settleUp(List<Expense> expenses);
    //will return the TransactionDTO list
    //we will pass List<Expenses>-> to settleUp the transactions
}
