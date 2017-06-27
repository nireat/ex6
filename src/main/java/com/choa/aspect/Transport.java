package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	
	//핵심 로직
	//버스 탈 때 내릴 때 카드 찍고, 지하철도 마찬가지
	public void bus(){
		System.out.println("자리 뺏기");
		System.out.println("옆사람 핸드폰 보기");
		System.out.println("BBBBBBBBBBBBBBBBBBB");
	}

	public void subway(){
		System.out.println("두리번 두리번");
		System.out.println("리니지 M 하기");
		System.out.println("SSSSSSSSSSSSSSSSSSS");
	}	
	
}
