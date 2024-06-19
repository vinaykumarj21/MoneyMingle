package com.project.Splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder    //Builder design pattern Annotation
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SPLITWISE_USER")
public class User extends BaseClass{
    private String Name;
    private String Email;
    private String PhoneNumber;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
}
