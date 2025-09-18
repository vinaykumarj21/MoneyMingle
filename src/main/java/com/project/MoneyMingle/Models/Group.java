package com.project.MoneyMingle.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity(name = "MoneyMingle_Group")
public class Group extends BaseClass{
    private String name;
    private String description;
    private double totalAmountSpend;

    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;
    @OneToMany
    @JoinColumn(name = "moneymingle_group_id")
    private List<Expense>expenses;

    @ManyToMany
    private List<User> users;
}
