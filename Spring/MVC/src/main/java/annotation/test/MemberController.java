package annotation.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "memberinsert";
	}

	@PostMapping("/memberinsert")
	public ModelAndView member(@ModelAttribute("dto") MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member");
		return mv;
	}
}
