package com.project.MoneyMingle.Service.IMPLs;

import com.project.MoneyMingle.DTO.ExpenseDTO;
import com.project.MoneyMingle.Exception.ExpenseNotFoundException;
import com.project.MoneyMingle.Exception.GroupNotFoundException;
import com.project.MoneyMingle.Models.Expense;
import com.project.MoneyMingle.Models.Group;
import com.project.MoneyMingle.Models.UserExpense;
import com.project.MoneyMingle.Models.UserExpenseType;
import com.project.MoneyMingle.Repository.ExpenseRepository;
import com.project.MoneyMingle.Repository.GroupRepository;
import com.project.MoneyMingle.Service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private GroupRepository groupRepository;
    //Creating an expense for the Particular Group
    @Override
    public ExpenseDTO createExpenseForGroup(int groupId, ExpenseDTO expenseDTO) throws GroupNotFoundException {
        Expense expense = modelmapper.map(expenseDTO,Expense.class);
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("Group Id : " + groupId + " is not present to create an expense for group"));

        List<Expense> expenses=group.getExpenses();
        if(expenses==null){
            expenses=new ArrayList<>();
        }
        expenses.add(expense);
        group.setExpenses(expenses);

        Expense savedExpense=expenseRepository.save(expense);
        groupRepository.save(group);

        return modelmapper.map(savedExpense,ExpenseDTO.class);
    }

    @Override
    public double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException, ExpenseNotFoundException {
        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()->new ExpenseNotFoundException("Expense with the "+expenseId+ " is not Created"));

        List<UserExpense>userExpenses=expense.getUserExpenses();
        double totalAmount=0;
        for(UserExpense expense1:userExpenses){
            if(expense1.getUserExpenseType().equals(UserExpenseType.Paid)){
                totalAmount+=  expense1.getAmount();
            }
        }
        expense.setAmount(totalAmount);
        expenseRepository.save(expense);
        return totalAmount;
    }
}
