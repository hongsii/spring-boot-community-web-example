package com.hongsii.springboot.community.web.example.repository;

import com.hongsii.springboot.community.web.example.domain.Board;
import com.hongsii.springboot.community.web.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

	Board findByUser(User user);
}
