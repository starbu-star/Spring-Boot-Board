package com.exe.Board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
//@Setter
public class HelloLombok {

	/* final�� ���� setter�� ����� �� ���� */
	/* �����ε��� �����ڸ� ���鶧 �ݵ�� ���� final�� �ؾ��� */
	private final String name;
	private final int age;
	
/*	public static void main(String[] args) {
		
		HelloLombok hk = new HelloLombok("���γ�",40);
		
//		hk.setName("�ÿ�");
//		hk.setAge(20);
	
		System.out.println(hk.getName());
		System.out.println(hk.getAge());
	}*/

	
}
