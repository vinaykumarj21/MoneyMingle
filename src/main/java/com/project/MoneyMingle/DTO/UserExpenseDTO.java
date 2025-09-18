package com.project.MoneyMingle.DTO;
import com.project.MoneyMingle.Models.UserExpenseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserExpenseDTO {
    private double amount;
    private UserExpenseType userExpenseType;
}
