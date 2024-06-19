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
public class GroupDTO {
    private String GroupName;
    private String Description;
    private Currency DefaultCurrency;
}
