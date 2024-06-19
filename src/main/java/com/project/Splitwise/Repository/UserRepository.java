package com.project.Splitwise.Repository;

import com.project.Splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//user creation
public interface UserRepository extends JpaRepository<User,Integer> {
}
