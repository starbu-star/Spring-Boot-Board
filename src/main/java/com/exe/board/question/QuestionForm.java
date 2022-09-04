package com.exe.Board.question;
/*
 * @Size ���� ���̸� �����Ѵ�.
 * 
 * @NotNull Null�� ������� �ʴ´�.
 * 
 * @NotEmpty Null �Ǵ� �� ���ڿ�("")�� ������� �ʴ´�.
 * 
 * @Past ���� ��¥�� ����
 * 
 * @Future �̷� ��¥�� ����
 * 
 * @FutureOrPresent�̷� �Ǵ� ���ó�¥�� ����
 * 
 * @Max �ִ밪
 * 
 * @Min �ּҰ�
 * 
 * @Pattern ����ȭ ǥ�������� ����
 */
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

	@NotEmpty(message = "������ ����ȿ..")	//(not null, ��������)
	@Size(max = 200)
	private String subject;
	
	@NotEmpty(message = "������ �����..")
	private String content;
	
}
