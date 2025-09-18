package com.project.MoneyMingle.Service;

import com.project.MoneyMingle.DTO.UserExpenseDTO;
import com.project.MoneyMingle.Exception.ExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserNotFoundException;
import java.util.List;

public interface UserExpenseService {
    void addUserExpense(int userId, UserExpenseDTO userExpenseDTO) throws UserNotFoundException;
    List<UserExpenseDTO>getSingleUserExpense(int userId);

    void addUserExpense(int userExpenseId,int expenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException;
}
