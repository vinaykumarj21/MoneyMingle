package com.project.Splitwise.Repository;

import com.project.Splitwise.Models.Expense;
import com.project.Splitwise.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

//Expense creation
public interface UserExpenseRepository extends JpaRepository<UserExpense,Integer> {
}
