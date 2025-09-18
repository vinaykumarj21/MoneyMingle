package com.project.MoneyMingle.Repository;

import com.project.MoneyMingle.Models.Group;
import com.project.MoneyMingle.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Group creation
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
