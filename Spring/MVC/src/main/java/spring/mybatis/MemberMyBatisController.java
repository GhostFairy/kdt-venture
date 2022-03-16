package spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMyBatisController {

	@Autowired
	MemberService service;

	@RequestMapping("/membermybatislist")
	public ModelAndView memberList() {
		List<MemberDTO> list = service.memberList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", list);
		mv.addObject("name", "전체 회원 목록");
		mv.setViewName("MyBatis/memberlist");
		return mv;
	}

	@RequestMapping("/membermybatispaginglist")
	public ModelAndView pagingList(int page) {
		List<MemberDTO> list = service.memberList((page - 1) * 5, 5);

		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", list);
		mv.addObject("name", "페이징 처리 회원 목록");
		mv.setViewName("MyBatis/memberlist");
		return mv;
	}

	@RequestMapping("/membermybatissearchlist")
	public ModelAndView searchList(String[] address) {
		List<String> list = service.memberList(address);

		ModelAndView mv = new ModelAndView();
		mv.addObject("membersearchlist", list);
		mv.addObject("name", "주소 검색 회원 목록");
		mv.setViewName("MyBatis/memberlist");
		return mv;
	}

	@GetMapping("/membermybatisinsert")
	public String insertForm() {
		return "MyBatis/insertform";
	}

	@PostMapping("/membermybatisinsert")
	public ModelAndView insertResult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", service.insertMember(dto));
		mv.setViewName("MyBatis/insertresult");
		return mv;
	}

	@GetMapping("/membermybatisupdate")
	public String updateForm(String id) {
		return "MyBatis/updateform";
	}

	@PostMapping("/membermybatisupdate")
	public ModelAndView updateResult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", service.updateMember(dto));
		mv.setViewName("MyBatis/updateresult");
		return mv;
	}

	@RequestMapping("membermybatisdelete")
	public String deleteResult(String id) {
		if (service.deleteMember(id) == 1) {
			return "redirect:/membermybatislist";
		} else {
			return "redirect:/membermybatisinsert";
		}
	}

}
