package hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping	클래스 + 메소드 단독 매핑
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) { // UserVo는 절대 null일 수 없음(값이 null일 수는 있음)
		System.out.println(userVo);
		return "redirect:/";
	}
	
	/* 가능하면 객체로 받는 게 좋음 (Wrapper 클래스를 통해, 값이 없는 경우 null 세팅) */
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") Long no) {
		/**
		 * 만일, n이라는 파라미터 이름이 없거나 값이 바르지 못하면
		 * 400 Bad Request Error가 발생한다.
		 */
		return "UserController:update(" + no + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=true, defaultValue="0") String name) {
		return "UserController:update2(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") Integer pageNo) {
		return "UserController:list(" + pageNo + ")";
	}
	
	
}
