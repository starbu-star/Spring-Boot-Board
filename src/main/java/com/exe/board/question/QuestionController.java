package com.exe.Board.question;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exe.Board.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

//�������� �տ� ��ǥ�� ���� �������ָ�, �Ʒ����� '/question'�κ��� �����ϰ� �ᵵ ��
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	//�����ε��� �����ھȿ� ������ �־��ַ��� �ݵ�� final�� ����?
	//private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
	//GetMappin, PostMapping�� ����. ���� ������θ� �ν��ؾ��� �� ���
	//Request�� ���������ʰ� ����.. ��� �⺻���� Get���
	@RequestMapping("/list")
	public String list(Model model,@PageableDefault Pageable pageable) {
		
		Page<Question> paging = questionService.getList(pageable);
		
		model.addAttribute("paging",paging);
		
		return "question_list";
	}
	
	//Thymeleaf,Mustache,Groovy,Freemarker,Velocity ���ø��� ����
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id
			,AnswerForm answerForm) {
		
		Question question = questionService.getQuestion(id);
		
		model.addAttribute("question", question);
		
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		
		
		return "question_form";
	}
	
	@PostMapping("/create")			//q.f�� ������ ������ �־ �˿�, bindingresult�� ��ȯ�Ǿ� ������ ���? ������ �ٲ�� �ȵ�.. �˿�->���
	public String questionCreate(@Valid QuestionForm questionForm,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		
		//�Է�
		questionService.create(questionForm.getSubject(), questionForm.getContent());
		
		return "redirect:/question/list";
		
	}
	
}
