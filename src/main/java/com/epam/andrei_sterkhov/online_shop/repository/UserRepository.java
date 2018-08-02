package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
