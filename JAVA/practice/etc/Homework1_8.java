// 8. 객체지향 방식으로 가위바위보를 하는데 두명의 선수가 무작위로
//    가위 바위 보를 낸 다음 승부를 출력하시오

class Player {

	String name;

	Player(String name) {
		this.name = name;
	}

	int decide() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			System.out.println(name + " \"가위!\"");
			return 0; // 가위
		case 1:
			System.out.println(name + " \"바위!\"");
			return 1; // 바위
		default:
			System.out.println(name + " \"보!\"");
			return -1; // 보
		}
	}

}

class Judge {

	void judge(Player p1, Player p2) {

		int decision1 = p1.decide();
		int decision2 = p2.decide();
		int result = 0;

		if (decision1 == decision2) {
			// 같은 패를 냈을 때:
			// 비김
			result = 0;
		} else if (decision1 == 0 && (decision1 > decision2)) {
			// 1번 선수가 가위(0)고, 비기지 않았을 때:
			// 2번 선수가 보(-1)면 이기고: 0 > -1 (true)
			// 2번 선수가 바위(1)면 짐: 0 > 1 (false)
			result = 1;
		} else if (decision1 == 1 && (decision1 != Math.abs(decision2))) {
			// 1번 선수가 바위(1)고, 비기지 않았을 때:
			// 2번 선수가 가위(0)면 이기고: 1 != 0 (true)
			// 2번 선수가 보(-1)면 짐: 1 != ABS(-1) (false)
			result = 1;
		} else if (decision1 == -1 && (Math.abs(decision1) == decision2)) {
			// 1번 선수가 보(-1)고, 비기지 않았을 때:
			// 2번 선수가 바위(1)면 이기고: ABS(-1) == 1 (true)
			// 2번 선수가 가위(0)면 짐: ABS(-1) == 0 (false)
			result = 1;
		} else {
			// 1번 선수가 이길 수 없는 조합이고, 비기지 않았을 때:
			// 2번 선수가 이김
			result = 2;
		}

		switch (result) {
		case 0:
			System.out.println("심판 \"비겼습니다.\"");
			break;
		case 1:
			System.out.println("심판 \"" + p1.name + " 선수의 승리!\"");
			break;
		default:
			System.out.println("심판 \"" + p2.name + " 선수의 승리!\"");
		}
	}

}

public class Homework1_8 {

	public static void main(String[] args) {

		Player p1 = new Player("A");
		Player p2 = new Player("B");
		Judge j = new Judge();

		j.judge(p1, p2);
	}

}
