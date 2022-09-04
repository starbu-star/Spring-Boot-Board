package com.exe.Board.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.exe.Board.answer.Answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //:jpa가 여기에 만드는 변수를 테이블을 만들면서 매칭시켜줌(엔티티로인식)
public class Question {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdDate;
	
	//question에 answer여러개 달렸을때 question지워지면 밑에 answer도 다 지우는거
	@OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)//,fetch = FetchType.EAGER)
			
	private List<Answer> answerList;
	
}
