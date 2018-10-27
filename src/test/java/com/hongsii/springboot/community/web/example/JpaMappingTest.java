package com.hongsii.springboot.community.web.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import com.hongsii.springboot.community.web.example.domain.Board;
import com.hongsii.springboot.community.web.example.domain.User;
import com.hongsii.springboot.community.web.example.domain.enums.BoardType;
import com.hongsii.springboot.community.web.example.repository.BoardRepository;
import com.hongsii.springboot.community.web.example.repository.UserRepository;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

	private final String boardTestTile = "테스트";
	private final String email = "test@gmail.com";


	@Autowired
	UserRepository userRepository;

	@Autowired
	BoardRepository boardRepository;

	@Before
	public void init() {
		User user = userRepository.save(User.builder()
			.name("havi")
			.password("test")
			.email(email)
			.createdDate(LocalDateTime.now())
			.build());
		boardRepository.save(Board.builder()
			.title(boardTestTile)
			.subTtitle("서브 타이틀")
			.content("내용")
			.boardType(BoardType.free)
			.createdDate(LocalDateTime.now())
			.updatedDate(LocalDateTime.now())
			.user(user)
			.build());
	}

	@Test
	public void 생성_확인() {
		User user = userRepository.findByEmail(email);
		assertThat(user.getName(), is("havi"));
		assertThat(user.getPassword(), is("test"));
		assertThat(user.getEmail(), is(email));

		Board board = boardRepository.findByUser(user);
		assertThat(board.getTitle(), is(boardTestTile));
		assertThat(board.getSubTtitle(), is("서브 타이틀"));
		assertThat(board.getContent(), is("내용"));
		assertThat(board.getBoardType(), is(BoardType.free));
	}
}