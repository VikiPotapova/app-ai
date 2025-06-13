package com.example.aidevbackendtask.repo;

import com.example.aidevbackendtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
