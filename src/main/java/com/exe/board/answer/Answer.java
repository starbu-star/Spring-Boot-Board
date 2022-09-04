package com.exe.Board.answer;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.exe.Board.question.Question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdDate;	
	
	@ManyToOne
	private Question question;
	//답변은 하나의 질문에 여러개가 달릴수 있다.
	//답변은 Many가 되고 질문이 One이됨
	
}
