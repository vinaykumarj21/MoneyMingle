package com.project.MoneyMingle.Repository;

import com.project.MoneyMingle.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

//Expense creation
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
