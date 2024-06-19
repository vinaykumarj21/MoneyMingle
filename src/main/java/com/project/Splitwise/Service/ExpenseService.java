package com.project.Splitwise.Service;

import com.project.Splitwise.DTO.ExpenseDTO;
import com.project.Splitwise.Exception.ExpenseNotFoundException;
import com.project.Splitwise.Exception.GroupNotFoundException;

public interface ExpenseService {
        ExpenseDTO createExpenseForGroup(int groupId,ExpenseDTO expenseDTO)throws GroupNotFoundException;
        double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException, ExpenseNotFoundException;
}
