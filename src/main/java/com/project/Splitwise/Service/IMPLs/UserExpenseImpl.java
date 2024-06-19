package com.project.Splitwise.Service.IMPLs;

import com.project.Splitwise.DTO.UserExpenseDTO;
import com.project.Splitwise.Exception.ExpenseNotFoundException;
import com.project.Splitwise.Exception.UserExpenseNotFoundException;
import com.project.Splitwise.Exception.UserNotFoundException;
import com.project.Splitwise.Models.Expense;
import com.project.Splitwise.Models.User;
import com.project.Splitwise.Models.UserExpense;
import com.project.Splitwise.Repository.ExpenseRepository;
import com.project.Splitwise.Repository.UserExpenseRepository;
import com.project.Splitwise.Repository.UserRepository;
import com.project.Splitwise.Service.UserExpenseService;
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
        Optional<UserExpense> userExpenses=userExpenseRepository.findById(userId);
        return userExpenses.stream()
                .map(userExpense -> modelMapper.map(userExpense,UserExpenseDTO.class))
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
