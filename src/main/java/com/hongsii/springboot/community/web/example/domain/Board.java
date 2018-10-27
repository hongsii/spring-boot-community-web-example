package com.hongsii.springboot.community.web.example.domain;

import com.hongsii.springboot.community.web.example.domain.enums.BoardType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Board {

	/**
	 * 스프링 부트
	 * 1.x 기본 키 할당 전략 : IDENTITY
	 * 2.x 기본 키 할당 전략 : TABLE
	 *
	 * 반드시 IDENTITY 선언 필요
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String subTitle;

	@Column
	private String content;

	@Column
	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Builder
	public Board(String title, String subTitle, String content,
			BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate,
			User user) {
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.boardType = boardType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.user = user;
	}
}
