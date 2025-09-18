package com.project.MoneyMingle.DTO;

import com.project.MoneyMingle.Models.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    private String groupName;
    private String description;
    private Currency defaultCurrency;
}
