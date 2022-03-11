package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");

		MemberService service = (MemberServiceImpl) factory.getBean("service");
		service.login();
		service.registerMember();
		service.login();
	}

}
