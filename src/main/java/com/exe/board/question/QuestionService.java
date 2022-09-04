package com.exe.Board.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exe.Board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

//Controller -> Service -> Repository

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	public Page<Question> getList(Pageable pageable){
		
		List<Sort.Order> sorts = new ArrayList<Sort.Order>();
		sorts.add(Sort.Order.desc("createdDate"));
		
		pageable = PageRequest.of(
				pageable.getPageNumber() <= 0 ? 0 : 
					pageable.getPageNumber() -1,
					pageable.getPageSize(),Sort.by(sorts));
		
		//getPageNumber : ��ȯ�� ������
		//getPageSize : ��ȯ�� �׸��� ��
		//PageRequest : ���� �Ű������� ����� ���ο� �׸��� ����		
		

		
		return questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
	
		Optional<Question> op = questionRepository.findById(id);
		
		if(op.isPresent())
			return op.get();
		else
			throw new DataNotFoundException("Question Not Found");
		
	}
	
	public void create(String subject,String content) {
		
		Question question = new Question();
		
		question.setSubject(subject);
		question.setContent(content);
		question.setCreatedDate(LocalDateTime.now());
		
		questionRepository.save(question);
	}
	

	
}
