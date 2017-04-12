package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class SendViewController {
	
	private static final Log LOG = LogFactory.getLog(SendViewController.class);
	
	public static final String EXAMPLE_VIEW = "example";
	//inyecta un componente que se encuentra en su memoria, y qualifier le indica el nombre del bean.
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent examComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	

	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping(value="/exampleString")
	public String exampleString(Model model){
		examComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	//@RequestMapping(value="exampleMAV", method=RequestMethod.GET)
	@GetMapping(value="/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
		modelAndView.addObject("people", exampleService.getListPeople());
		return modelAndView;
	}
	

}
