package com.example.savemoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.savemoney.models.users.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
