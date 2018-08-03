package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
