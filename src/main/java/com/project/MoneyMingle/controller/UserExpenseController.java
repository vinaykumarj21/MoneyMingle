package com.project.MoneyMingle.Controller;

import com.project.MoneyMingle.DTO.UserExpenseDTO;
import com.project.MoneyMingle.Exception.ExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserExpenseNotFoundException;
import com.project.MoneyMingle.Exception.UserNotFoundException;
import com.project.MoneyMingle.Service.UserExpenseService;
import com.project.MoneyMingle.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userExpense")
public class UserExpenseController {
    @Autowired
    private UserExpenseService userExpenseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    //Creating the UserExpense
    @PostMapping("/{userId}/createExpense")
    public ResponseEntity createUserExpense(@PathVariable int userId, @RequestBody UserExpenseDTO userExpenseDTO) throws UserNotFoundException {
        userExpenseService.addUserExpense(userId,userExpenseDTO);
        return new ResponseEntity<>("User Expense Added Successfully", HttpStatus.CREATED);
    }

    //Adding a particular Expense to a Group Expense
    @PostMapping("/{expenseId}/addUserExpense/{userExpenseId}")
    public ResponseEntity addUserExpenseToGroupExpense(@PathVariable int expenseId,@PathVariable int userExpenseId) throws UserExpenseNotFoundException, ExpenseNotFoundException {
        userExpenseService.addUserExpense(expenseId,userExpenseId);
        return new ResponseEntity<>("User Expense has been added Successfully in group",HttpStatus.CREATED);
    }

}
