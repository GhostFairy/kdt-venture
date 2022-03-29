package edu.multi.my;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import clova.ai.clovavoice.CVService;
import clova.ai.clovavoice.CVServiceImpl;

@Controller
public class MyController {

	@Autowired
	@Qualifier("MyService")
	MyService myService = new MyServiceImpl();

	@Autowired
	@Qualifier("CVService")
	CVService cvService = new CVServiceImpl();

	@GetMapping("/my")
	public String myInput() {
		return "my/input";
	}

	@PostMapping("/my")
	public ModelAndView myOutput(String q) {
		if (q != null) {
			q = q.replace(" ", "");
		}
		ModelAndView mv = new ModelAndView();

		String response = myService.query(q);
		String path = "C:/ai_images/";
		String textfile = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".txt";
		try {
			FileWriter file = new FileWriter(path + textfile);
			file.write(response);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String speechfile = cvService.tts("noyj", textfile);
		mv.addObject("response", response);
		mv.addObject("speech", speechfile);
		mv.setViewName("my/output");
		return mv;
	}

}
