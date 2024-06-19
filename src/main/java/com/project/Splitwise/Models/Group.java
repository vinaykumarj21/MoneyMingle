package com.project.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity(name = "Splitwise_Group")
public class Group extends BaseClass{
    private String Name;
    private String Description;
    private double TotalAmountSpend;

    @Enumerated(EnumType.STRING)
    private Currency DefaultCurrency;
    @OneToMany
    @JoinColumn(name = "splitwise_group_id")
    private List<Expense>expenses;

    @ManyToMany
    private List<User> users;
}
