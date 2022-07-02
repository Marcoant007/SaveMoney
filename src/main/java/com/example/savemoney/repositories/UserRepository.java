package com.example.savemoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.savemoney.models.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
