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
@Entity //:jpa�� ���⿡ ����� ������ ���̺��� ����鼭 ��Ī������(��ƼƼ���ν�)
public class Question {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createdDate;
	
	//question�� answer������ �޷����� question�������� �ؿ� answer�� �� ����°�
	@OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)//,fetch = FetchType.EAGER)
			
	private List<Answer> answerList;
	
}
