package com.project.Splitwise.Service.IMPLs;

import com.project.Splitwise.Models.*;
import com.project.Splitwise.Repository.ExpenseRepository;
import com.project.Splitwise.Repository.GroupRepository;
import com.project.Splitwise.Repository.UserExpenseRepository;
import com.project.Splitwise.Repository.UserRepository;
import com.project.Splitwise.Service.initService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class initServiceImpl implements initService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void init() {
        Group group=new Group();
        group.setId(1);
        group.setName("Goa Trip");
        group.setDescription("Goa Trip 2023");
        group.setDefaultCurrency(Currency.INR);
        Group savedGroup =groupRepository.save(group);//for id

        User user1=User.builder()
                .Name("Yash")
                .Email("yash@gmail.com")
                .PhoneNumber("8475635462")
                .groups(List.of(savedGroup)).build();

        User user2=User.builder()
                .Name("Sandeep")
                .Email("sandy@gmail.com")
                .PhoneNumber("7485637221")
                .groups(List.of(savedGroup)).build();

        User user3=User.builder()
                .Name("Swapnil")
                .Email("swapnil@gmail.com")
                .PhoneNumber("9940506070")
                .groups(List.of(savedGroup)).build();

        User user4=User.builder()
                .Name("Amit")
                .Email("amit@gmail.com")
                .PhoneNumber("8475635662")
                .groups(List.of(savedGroup)).build();

        User user5=User.builder()
                .Name("Pratik")
                .Email("pratik@gmail.com")
                .PhoneNumber("9975635662")
                .groups(List.of(savedGroup)).build();

        User user6=User.builder()
                .Name("Sahil")
                .Email("sahil@gmail.com")
                .PhoneNumber("8475635782")
                .groups(List.of(savedGroup)).build();

        User savedUser1=userRepository.save(user1);
        User savedUser2=userRepository.save(user2);
        User savedUser3=userRepository.save(user3);
        User savedUser4=userRepository.save(user4);
        User savedUser5=userRepository.save(user5);
        User savedUser6=userRepository.save(user6);

        savedGroup.setUsers(List.of(savedUser1,savedUser2,savedUser3,savedUser4,savedUser5,savedUser6));
        savedGroup=groupRepository.save(savedGroup);

        UserExpense userExpense1=new UserExpense();
        userExpense1.setUserExpenseType(UserExpenseType.HadToPay);
        userExpense1.setAmount(500);
        userExpense1.setUser(savedUser1);
        UserExpense savedUserExpense1=userExpenseRepository.save(userExpense1);

        UserExpense userExpense2=new UserExpense();
        userExpense2.setUserExpenseType(UserExpenseType.HadToPay);
        userExpense2.setAmount(2000);
        userExpense2.setUser(savedUser2);
        UserExpense savedUserExpense2=userExpenseRepository.save(userExpense2);

        UserExpense userExpense3=new UserExpense();
        userExpense3.setUserExpenseType(UserExpenseType.HadToPay);
        userExpense3.setAmount(500);
        userExpense3.setUser(savedUser3);
        UserExpense savedUserExpense3=userExpenseRepository.save(userExpense3);

        UserExpense userExpense4=new UserExpense();
        userExpense4.setUserExpenseType(UserExpenseType.Paid);
        userExpense4.setAmount(1500);
        userExpense4.setUser(savedUser4);
        UserExpense savedUserExpense4=userExpenseRepository.save(userExpense4);

        UserExpense userExpense5=new UserExpense();
        userExpense5.setUserExpenseType(UserExpenseType.Paid);
        userExpense5.setAmount(500);
        userExpense5.setUser(savedUser5);
        UserExpense savedUserExpense5=userExpenseRepository.save(userExpense5);

        UserExpense userExpense6=new UserExpense();
        userExpense6.setUserExpenseType(UserExpenseType.Paid);
        userExpense6.setAmount(1000);
        userExpense6.setUser(savedUser6);
        UserExpense savedUserExpense6=userExpenseRepository.save(userExpense6);

        Expense expense=new Expense();
        expense.setDescription("Total Trip Expense");
        expense.setAmount(3000);
        expense.setUserExpenses(List.of(savedUserExpense1,savedUserExpense2,
                savedUserExpense3,savedUserExpense4,savedUserExpense5,savedUserExpense6));
        expense.setCurrency(Currency.INR);
        Expense savedExpense=expenseRepository.save(expense);

        savedGroup.setExpenses(List.of(savedExpense));
        groupRepository.save(savedGroup);

    }
}
