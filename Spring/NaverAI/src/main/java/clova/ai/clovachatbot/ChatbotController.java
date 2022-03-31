package clova.ai.clovachatbot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import clova.ai.clovaspeechrecognition.CSRService;
import clova.ai.clovaspeechrecognition.CSRServiceImpl;
import clova.ai.clovavoice.CVService;
import clova.ai.clovavoice.CVServiceImpl;

@Controller
public class ChatbotController {

	@Autowired
	@Qualifier("ChatbotService")
	ChatbotService chatbotService = new ChatbotServiceImpl();

	@Autowired
	@Qualifier("CVService")
	CVService cvService = new CVServiceImpl();

	@Autowired
	@Qualifier("CSRService")
	CSRService csrService = new CSRServiceImpl();

	/*
	@RequestMapping("/chatbot/request")
	public String chatbotRequest() {
		return "chatbot/request";
	}

	@RequestMapping("/chatbot/response")
	public ModelAndView chatbotResponse(String voiceMessage, String event) {
		if (event == null || event.equals("답변")) {
			event = "send";
		} else if (event.equals("웰컴메시지")) {
			event = "open";
		}
		ModelAndView mv = new ModelAndView();
		String json = chatbotService.chatbot(voiceMessage, event);
		mv.addObject("response", json);
		mv.setViewName("chatbot/response");
		return mv;
	}
	*/

	@RequestMapping("/chatbot")
	public String chatbot() {
		return "chatbot/chatbot";
	}

	@RequestMapping("/chatbottext")
	@ResponseBody
	public String chatbotAJAX(String voiceMessage, String event) {
		if (event == null) {
			event = "send";
		}
		return chatbotService.chatbot(voiceMessage, event);
	}

	@RequestMapping("/chatbottts")
	@ResponseBody
	public String chatbotTTS(String speaker, String text) {
		return "{\"filename\":\"" + cvService.tts(speaker, text) + "\"}";
	}

	@PostMapping("/chatbotaudio")
	@ResponseBody
	public String chatbotAudio(String lang, MultipartFile audio) {
		String tempname = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		try {
			File f = new File("C:/ai_images/" + tempname + ".mp3");
			audio.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csrService.stt(lang, tempname + ".mp3");
	}

	@RequestMapping("/chatbotpizza")
	@ResponseBody
	public String pizza(String pizza, String size, String phone) {
		String[] menu = { "콤비네이션피자", "치즈피자", "불고기피자" };
		int[] price = { 12000, 10000, 13000 };
		int pay = 0;
		for (int i = 0; i < menu.length; i++) {
			if (pizza.equals(menu[i])) {
				switch (size) {
				case "L":
					pay = price[i] + 5000;
					break;
				case "M":
					pay = price[i] + 2500;
					break;
				default:
					pay = price[i];
				}
				break;
			}
		}
		return "[ " + phone + " ]<br>주문 결과: " + pizza + " / " + size + "<br>결제 금액: " + pay + "원";
	}
}
