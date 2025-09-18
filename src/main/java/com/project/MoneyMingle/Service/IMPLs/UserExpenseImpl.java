package com.project.MoneyMingle.Service.IMPLs;

import com.project.MoneyMingle.DTO.UserExpenseDTO;
import com.project.MoneyMingle.Exception.ExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserNotFoundException;
import com.project.MoneyMingle.Models.Expense;
import com.project.MoneyMingle.Models.User;
import com.project.MoneyMingle.Models.UserExpense;
import com.project.MoneyMingle.Repository.ExpenseRepository;
import com.project.MoneyMingle.Repository.UserExpenseRepository;
import com.project.MoneyMingle.Repository.UserRepository;
import com.project.MoneyMingle.Service.UserExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserExpenseImpl implements UserExpenseService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    //Adding Expense of the User(paid/hadToPay)
    @Override
    public void addUserExpense(int userId, UserExpenseDTO userExpenseDTO) throws UserNotFoundException {
        UserExpense userExpense=modelMapper.map(userExpenseDTO,UserExpense.class);
        User user=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User with the ID: "+userId+" not Found"));
        userExpense.setUser(user);
        userExpenseRepository.save(userExpense);
    }

    //getting userExpense of a Particular user
    @Override
    public List<UserExpenseDTO> getSingleUserExpense(int userId) {
        // This method should find all UserExpenses for a specific user, not by userExpense ID
        // We need to find by user ID, so we should use a custom query in the repository
        // For now, implementing a basic solution that finds all and filters by user
        List<UserExpense> allUserExpenses = userExpenseRepository.findAll();
        return allUserExpenses.stream()
                .filter(userExpense -> userExpense.getUser() != null && userExpense.getUser().getId() == userId)
                .map(userExpense -> modelMapper.map(userExpense, UserExpenseDTO.class))
                .collect(Collectors.toList());
    }

    //Adding a particular User Expense to a group Expense
    @Override
    public void addUserExpense(int userExpenseId, int expenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException {
        UserExpense userExpense=userExpenseRepository.findById(userExpenseId)
                .orElseThrow(()->new UserExpenseNotFoundException("User Expense not yet Created for the User Expense ID :"+ userExpenseId));

        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()->new ExpenseNotFoundException("The Expense with the ExpenseId: "+expenseId+ "Hasn't been Registered yet. Register the Expense with ExpenseId:"+expenseId));

        List<UserExpense>userExpenses=expense.getUserExpenses();

        if(userExpenses==null){
            userExpenses=new ArrayList<>();
        }

        userExpenses.add(userExpense);
        expense.setUserExpenses(userExpenses);
        expenseRepository.save(expense);
    }
}
