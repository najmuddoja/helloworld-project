package com.next.hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Testcontroller {
	
	@RequestMapping("/")
	public ModelAndView firstPage(){
		return new ModelAndView("welcome");
	}

}
