package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter {

	//controller 빠져나올 때. 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			System.out.println("controller 나온 후");
			Map<String, Object> map = modelAndView.getModel();
			//noticeController의 ar
			Object list = map.get("list");
			Object listInfo = map.get("listInfo");
			Object board = map.get("board");
			//modelAndView.addObject(attributeName, attributeValue); 를 넣을 수도 있음
			//modelAndView.setViewName("home");
			System.out.println(((List<BoardDTO>)list).get(0).getTitle());
			System.out.println(((ListInfo)listInfo).getCurBlock());
			System.out.println(board);
	}

	//controller 가기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Controller 가기 전");
		return true;
		//true : , false :
	}
	
	
	

}
