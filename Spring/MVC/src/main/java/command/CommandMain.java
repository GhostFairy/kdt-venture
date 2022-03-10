package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("command/command.xml");

		Command[] comArr = new Command[3];
		comArr[0] = (BoardCommand) ac.getBean("board");
		comArr[1] = (MemberCommand) ac.getBean("member");
		comArr[2] = (ProductCommand) ac.getBean("product");

		for (Command com : comArr) {
			com.run();
		}

	}

}
