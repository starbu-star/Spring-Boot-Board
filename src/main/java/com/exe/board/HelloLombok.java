package com.exe.Board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
//@Setter
public class HelloLombok {

	/* final을 쓰면 setter를 사용할 수 없음 */
	/* 오버로딩된 생성자를 만들때 반드시 변수 final로 해야함 */
	private final String name;
	private final int age;
	
/*	public static void main(String[] args) {
		
		HelloLombok hk = new HelloLombok("유인나",40);
		
//		hk.setName("시연");
//		hk.setAge(20);
	
		System.out.println(hk.getName());
		System.out.println(hk.getAge());
	}*/

	
}
