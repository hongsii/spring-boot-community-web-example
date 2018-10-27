package com.hongsii.springboot.community.web.example.repository;

import com.hongsii.springboot.community.web.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
