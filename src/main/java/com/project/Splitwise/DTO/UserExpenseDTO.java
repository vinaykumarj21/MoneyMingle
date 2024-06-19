package com.project.Splitwise.DTO;
import com.project.Splitwise.Models.UserExpenseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserExpenseDTO {
    private int Amount;
    private UserExpenseType userExpenseType;
}
