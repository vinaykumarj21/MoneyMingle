package com.project.MoneyMingle.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder    //Builder design pattern Annotation
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MONEYMINGLE_USER")
public class User extends BaseClass{
    private String name;
    private String email;
    private String phoneNumber;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
}
