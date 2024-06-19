package com.project.Splitwise.DTO;

import com.project.Splitwise.Models.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {
    private String Description;
    private Currency currency;
}
