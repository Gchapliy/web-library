package com.example.weblibrary.repository;

import com.example.weblibrary.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}