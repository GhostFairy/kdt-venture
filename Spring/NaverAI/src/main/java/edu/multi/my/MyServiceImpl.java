package edu.multi.my;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service("MyService")
public class MyServiceImpl implements MyService {

	HashMap<String, String> map = new HashMap<String, String>();

	public MyServiceImpl() {
		map.put("이름이뭐니?", "CLOVA야");
		map.put("무슨일을하니?", "AI 서비스 관련 일을 해");
		map.put("멋진일을하는구나", "고마워");
		map.put("난훌륭한개발자가될거야", "넌 할 수 있어");
		map.put("잘자", "내 꿈 꿔");
	}

	@Override
	public String query(String q) {
		String response = map.get(q);
		if (response != null) {
			return response;
		} else {
			return "답변할 수 없습니다.";
		}
	}

}
