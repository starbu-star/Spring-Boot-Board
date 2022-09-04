package com.exe.Board.answer;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

	@NotEmpty(message = "내용을 써")
	private String content;
	
}
