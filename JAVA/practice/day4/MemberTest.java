
class Member {

	String memberId;
	int memberPass;
	String memberName;
	int memberAge;

	void insert(String id, int password, String name, int age) {
		memberId = id;
		memberPass = password;
		memberName = name;
		memberAge = age;

		System.out.println("아이디: " + memberId);
		System.out.println("이름: " + memberName);
		System.out.println("나이: " + memberAge);
		System.out.println("가입 완료되었습니다.");
		System.out.println();
	}

	void login(String id, int password) {
		if (id.equals(memberId)) {
			if (password == memberPass) {
				System.out.println("로그인되었습니다.");
				System.out.println();
			} else {
				System.out.println("암호를 다시 확인하세요.");
				System.out.println();
			}
		} else {
			System.out.println("아이디를 다시 확인하세요.");
			System.out.println();
		}
	}

	void setPassword(int password) {
		memberPass = password;
	}

	void getMyInfo() {
		System.out.println("아이디: " + memberId);
		System.out.println("암호: " + memberPass);
		System.out.println("이름: " + memberName);
		System.out.println("나이: " + memberAge);
		System.out.println();
	}

	String logout() {
		System.out.println("로그아웃되었습니다.");
		System.out.println();

		memberId = null;
		memberPass = -1;
		memberName = null;
		memberAge = -1;

		return memberId;
	}

}

public class MemberTest {

	public static void main(String[] args) {
		Member mem = new Member();

		mem.insert("test", 1234, "이자바", 25);

		mem.login("test", 4321);
		mem.login("test", 1234);

		mem.setPassword(1111);
		mem.getMyInfo();

		String id = mem.logout();

		if (id == null) {
			System.out.println("다시 로그인하셔야 합니다.");
		}
	}

}
