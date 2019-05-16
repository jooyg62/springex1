package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	/**
	 * 리턴 값에 대한 VR 처리는 세가지가 있다.(String, ModelAndView, Object)
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		 return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("email", "jooyg62@naver.com");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("email", "dooly@naver.com");
		return "/WEB-INF/views/hello.jsp";
	}
	
	/**
	 * http://localhost:8080/springex1/hello4?e=nknknknkn
	 * @param model
	 * @param email
	 * @return
	 */
	/* 기술 침투 (쓰레기)*/
	@RequestMapping("hello5")
	public String hello5(Model model, HttpServletRequest request){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println( name );
		model.addAttribute("email", email);
		return "/WEB-INF/views/hello.jsp";
	}
}
