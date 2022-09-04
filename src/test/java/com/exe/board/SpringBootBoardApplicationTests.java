package com.exe.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exe.Board.question.Question;
import com.exe.Board.question.QuestionRepository;
import com.exe.Board.question.QuestionService;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void contextLoads() {
	}

	/*
	@Test
	void save() {
		
		Question q1 = new Question();
		q1.setSubject("커피가맛있어요");
		q1.setContent("스타벅스리저브최고");
		q1.setCreatedDate(LocalDateTime.now());
		
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("목욜이에요");
		q2.setContent("왜금요일이 아닌지..");
		q2.setCreatedDate(LocalDateTime.now());
		
		this.questionRepository.save(q2);	
	}
		
	
	@Test
	void findAll() {
		
		List<Question> lists = questionRepository.findAll();
		
		assertEquals(10, lists.size());
		
		Question q = lists.get(1);
		assertEquals("집가고싶아요", q.getSubject());				
	}
	
	
	@Test
	void findBySubject() {
		
		Question q = questionRepository.findBySubject("집가고싶아요");
		
		assertEquals(1, q.getId());
				
	}

	
	@Test
	void findBySubjectAndContent() {
		
		List<Question> lists = questionRepository
				.findBySubjectAndContent("집가고싶아요", "마라샹궈먹고싶아요");
		
		Question q = lists.get(1);
		
		//assertEquals(1, q.getId());
		assertEquals(1, q.getId());
		
	}
	
	
	
	@Test
	void findBySubjectAndContent() {
		
		Question q = questionRepository
				.findBySubjectAndContent("집가고싶아요", "마라샹궈먹고싶아요");
		
		assertEquals(1, q.getId());
		
	}
	
	@Test
	void findBySubjectLike() {
		List<Question> lists = questionRepository.findBySubjectLike("스%");
		
		Question q = lists.get(0);
		
		assertEquals("스프링 부트가 무엇인가요?", q.getSubject());
		
	}
	
	@Test
	void update() {
		
		Optional<Question> op = questionRepository.findById(1);
		assertTrue(op.isPresent());
		
		Question q = op.get();
		q.setSubject("스프링");
		q.setContent("스프링 부트");
		
		questionRepository.save(q);
	}
	
	@Test
	void delete() {
		
		assertEquals(2, questionRepository.count());
		
		Optional<Question> op = questionRepository.findById(1);
		assertTrue(op.isPresent());
		
		Question q = op.get();
		questionRepository.delete(q);
		
		assertEquals(1, questionRepository.count());
	
	
	}
	*/
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void save200() {
		
		for(int i=1;i<200;i++) {
			String subject = String.format("테스트 데이터 입니다:[%03d]", i);
			String content = String.format("오늘 저녁은 곱창입니다:[%03d]", i);
			
			questionService.create(subject, content);
		}
		
	}
	
	
	
	
	
	
	
	
}
