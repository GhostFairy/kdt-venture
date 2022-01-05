// 7. 객체지향 방식으로 로또 번호 추천기를 만드시오

import java.util.Arrays;

class Lotto {

	int[] number = new int[6];

	int pop() {
		// 1 ~ 45 사이의 정수 생성
		return (int) (Math.random() * 45 + 1);
	}

	int[] recommend() {
		for (int i = 0; i < 6; i++) {
			int number = 0;
			boolean flag = true;

			while (flag) {
				number = pop();
				flag = false;

				for (int j = 0; j < i; j++) {
					if (number == this.number[j]) {
						flag = true;
						break;
					}
				}
			}

			this.number[i] = number;
		}

		Arrays.sort(number);
		return number;
	}

}

public class Homework1_7 {

	public static void main(String[] args) {
		Lotto l = new Lotto();

		int[] rec = l.recommend();

		for (int i = 0; i < rec.length; i++) {
			System.out.print("[" + rec[i] + "]");
		}
		System.out.println();
	}

}
