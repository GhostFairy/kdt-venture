
class Student {

	String name;
	String inst;
	String course;
	int eduFee;
	int addFee;
	double retFee;

}

public class StudentTest {

	public static void main(String[] args) {
		// Student 클래스 객체를 참조하는 변수 student 선언
		Student student = new Student();

		// 입력 변수 args[]의 값을 이용해 student를 초기화
		// 이자바 멀티캠퍼스 JSP프로그래밍 50000 5000
		student.name = args[0];
		student.inst = args[1];
		student.course = args[2];
		student.eduFee = Integer.parseInt(args[3]);
		student.addFee = Integer.parseInt(args[4]);

		/*
		// 과정에 따른 환급금 계산
		switch (student.course) {
		case "자바프로그래밍":
			student.retFee = student.eduFee * 0.25 + student.addFee;
			break;
		case "JDBC프로그래밍":
			student.retFee = student.eduFee * 0.20 + student.addFee;
			break;
		case "JSP프로그래밍":
			student.retFee = student.eduFee * 0.15 + student.addFee;
			break;
		default:
			System.out.println("잘못 입력되었습니다");
			return;
		}
		*/

		// 과정에 따른 환급금 계산 (if 사용)
		if (student.course.equals("자바프로그래밍"))

		{ // 객체의 비교는 .equals() 메소드 사용
			student.retFee = student.eduFee * 0.25 + student.addFee;
		} else if (student.course.equalsIgnoreCase("JDBC프로그래밍")) { // 영문 대소문자 구분 없이 비교하고 싶을 땐 .equalsIgnoreCase()
			student.retFee = student.eduFee * 0.20 + student.addFee;
		} else if (student.course.equalsIgnoreCase("JSP프로그래밍")) {
			student.retFee = student.eduFee * 0.15 + student.addFee;
		} else {
			System.out.println("잘못 입력되었습니다");
			return;
		}

		// student가 참조하는 객체 내부의 값 출력
		System.out.println("이름: " + student.name);
		System.out.println("소속: " + student.inst);
		System.out.println();
		System.out.println("과정명: " + student.course);
		System.out.println("교육비: " + student.eduFee);
		System.out.println("부가금: " + student.addFee);
		System.out.println("환급금: " + student.retFee);
	}

}
