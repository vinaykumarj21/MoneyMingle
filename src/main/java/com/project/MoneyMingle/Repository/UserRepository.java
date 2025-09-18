package com.project.MoneyMingle.Repository;

import com.project.MoneyMingle.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//user creation
public interface UserRepository extends JpaRepository<User,Integer> {
}
