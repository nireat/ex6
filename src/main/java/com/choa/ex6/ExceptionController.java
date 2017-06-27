package com.choa.ex6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model model){
		model.addAttribute("e", e.getMessage());
		//개발단계에서는 메세지를 봐야함
		//배포단계에서 메세지 지워줄 것
		return "error/notFound";
	}
	

}
