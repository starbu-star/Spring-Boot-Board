package com.exe.Board;

/*
org.springframework.data.domain.Page
org.springframework.data.domain.PageRequest
 : ����¡�� ���� ������ ���� Pageable interface�� ���� ���� Ŭ����
org.springframework.data.domain.Pageable
 : ����¡�� ���� ������ ��� �ִ� �������̽�
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/sbb")
	@ResponseBody
	public String hello() {
		return "����������";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/question/list";		
	}
	
	
	
}
