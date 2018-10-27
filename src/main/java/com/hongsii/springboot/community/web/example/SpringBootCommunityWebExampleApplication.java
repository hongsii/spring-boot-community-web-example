package com.hongsii.springboot.community.web.example;

import com.hongsii.springboot.community.web.example.domain.Board;
import com.hongsii.springboot.community.web.example.domain.User;
import com.hongsii.springboot.community.web.example.domain.enums.BoardType;
import com.hongsii.springboot.community.web.example.repository.BoardRepository;
import com.hongsii.springboot.community.web.example.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCommunityWebExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommunityWebExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository,
			BoardRepository boardRepository) {
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("hong")
					.password("test")
					.email("hong@gmail.com")
					.createdDate(LocalDateTime.now())
					.build());
			IntStream.rangeClosed(1, 200).forEach(index ->
					boardRepository.save(Board.builder()
					.title("게시글" + index)
					.subTitle("순서" + index)
					.content("내용")
					.boardType(BoardType.free)
					.createdDate(LocalDateTime.now())
					.updatedDate(LocalDateTime.now())
					.user(user)
					.build())
			);
		};
	}

}
