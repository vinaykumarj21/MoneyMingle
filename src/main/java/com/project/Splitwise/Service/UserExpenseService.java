package com.project.Splitwise.Service;

import com.project.Splitwise.DTO.UserExpenseDTO;
import com.project.Splitwise.Exception.ExpenseNotFoundException;
import com.project.Splitwise.Exception.UserExpenseNotFoundException;
import com.project.Splitwise.Exception.UserNotFoundException;
import java.util.List;

public interface UserExpenseService {
    void addUserExpense(int userId, UserExpenseDTO userExpenseDTO) throws UserNotFoundException;
    List<UserExpenseDTO>getSingleUserExpense(int userId);

    void addUserExpense(int userExpenseId,int expenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException;
}
