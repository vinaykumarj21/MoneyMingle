package com.project.Splitwise.Repository;

import com.project.Splitwise.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

//Expense creation
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
