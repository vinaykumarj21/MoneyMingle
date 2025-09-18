package com.project.MoneyMingle.Repository;

import com.project.MoneyMingle.Models.Expense;
import com.project.MoneyMingle.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

//Expense creation
public interface UserExpenseRepository extends JpaRepository<UserExpense,Integer> {
}
