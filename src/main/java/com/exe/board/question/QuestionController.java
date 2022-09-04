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

//매핑으로 앞에 좌표를 먼저 설정해주면, 아래에서 '/question'부분은 생략하고 써도 됨
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	//오버로딩된 생성자안에 변수를 넣어주려면 반드시 final로 선언?
	//private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
	//GetMappin, PostMapping도 존재. 각각 방식으로만 인식해야할 때 사용
	//Request는 구분하지않고 쓸때.. 대신 기본값은 Get방식
	@RequestMapping("/list")
	public String list(Model model,@PageableDefault Pageable pageable) {
		
		Page<Question> paging = questionService.getList(pageable);
		
		model.addAttribute("paging",paging);
		
		return "question_list";
	}
	
	//Thymeleaf,Mustache,Groovy,Freemarker,Velocity 템플릿의 종류
	
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
	
	@PostMapping("/create")			//q.f에 들어오는 변수를 넣어서 검열, bindingresult는 반환되어 나오는 결과? 순서가 바뀌면 안됨.. 검열->결과
	public String questionCreate(@Valid QuestionForm questionForm,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		
		//입력
		questionService.create(questionForm.getSubject(), questionForm.getContent());
		
		return "redirect:/question/list";
		
	}
	
}
