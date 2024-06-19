package com.project.Splitwise.Repository;

import com.project.Splitwise.Models.Group;
import com.project.Splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Group creation
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
