package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}