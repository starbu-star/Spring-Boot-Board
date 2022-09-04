package com.exe.Board;

/*
org.springframework.data.domain.Page
org.springframework.data.domain.PageRequest
 : 페이징에 대한 정보를 담은 Pageable interface의 실제 구현 클래스
org.springframework.data.domain.Pageable
 : 페이징에 대한 정보를 담고 있는 인터페이스
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/sbb")
	@ResponseBody
	public String hello() {
		return "메인페이지";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/question/list";		
	}
	
	
	
}
