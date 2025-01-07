package validation.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import validation.domain.User;

@Controller
public class MvcController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/result")
	public String result() {
		return "result";
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		return "form/ex01";
	}
	
	// @ModelAttribute : 요청 파라미터를 객체로 바인딩하고, 그 객체를 자동으로 모델에 추가한다.
	@PostMapping("/ex01")
	public String ex01(@ModelAttribute @Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
//			List<ObjectError> errors = result.getAllErrors();
//			for(ObjectError error : errors) {
//				System.out.println(error);
//			}
			
			Map<String, Object> map = result.getModel();			
//			Set<String> s= map.keySet();
//			for(String key : s) {
//				model.addAttribute(key, map.get(key));
//			}
			model.addAllAttributes(map); // view에서 ${map.name}이 아닌, ${name}로만 써도 된다.
			return "form/ex01";
		}
		
		return "redirect:/result";
	}
	
	@GetMapping("/ex02")
	public String ex02() {
		return "form/ex02";
	}
	
	@PostMapping("/ex02")
	public String ex02(@ModelAttribute @Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "form/ex02";
		}
		
		return "redirect:/result";
	}
	
	@GetMapping("/ex03")
	public String ex03(@ModelAttribute User user) {
		return "form/ex03";
	}
	
	@PostMapping("/ex03")
	public String ex03(@ModelAttribute @Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "form/ex03";
		}
		
		return "redirect:/result";
	}		
}
