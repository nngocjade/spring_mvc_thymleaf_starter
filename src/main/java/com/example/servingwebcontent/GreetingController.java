package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller // means that this serves web pages, rather than API responses
@RequestMapping("/mvc")
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name="name", required=false, defaultValue="World") String name,
			Model model) {

		model.addAttribute("name", name);

		ArrayList<Student> students = getStudents();
		model.addAttribute("students", students);

		return "greeting";
	}

	public static ArrayList<Student> getStudents(){
		ArrayList<Student> students = new ArrayList();

		students.add(new Student(1, "Ben"));
		students.add(new Student(2, "Mimi"));
		students.add(new Student(3, "Joe"));
		students.add(new Student(4, "Isadora"));

		return students;
	}

//	@RequestMapping(value={"/old"}, method = RequestMethod.GET)
//	public ModelAndView getYoung(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("old.html");
//		return modelAndView;
//	}
}
