package com.project.MoneyMingle.Service;

import com.project.MoneyMingle.DTO.ExpenseDTO;
import com.project.MoneyMingle.Exception.ExpenseNotFoundException;
import com.project.MoneyMingle.Exception.GroupNotFoundException;

public interface ExpenseService {
        ExpenseDTO createExpenseForGroup(int groupId,ExpenseDTO expenseDTO)throws GroupNotFoundException;
        double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException, ExpenseNotFoundException;
}
