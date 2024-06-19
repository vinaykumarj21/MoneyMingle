package com.project.Splitwise.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor//parameterised Constructor
@NoArgsConstructor//default Constructor
public class TransactionDTO {//to Transfer some data back to the user(

    private String fromUserName;
    private String toUserName;
    private double amount;

}
