package com.hongsii.springboot.community.web.example.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;

	@Builder
	public User(String name, String password, String email, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
}
