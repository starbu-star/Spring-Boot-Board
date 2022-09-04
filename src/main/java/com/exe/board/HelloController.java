package com.exe.Board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController : @Controller + @ResponseBody 
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody //text¸¦ ¶ç¿ï¶§
	public String hello() {
		
		return "hello World";
	}
	
}
