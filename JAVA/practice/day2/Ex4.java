
public class Ex4 {

	public static void main(String[] args) {
		// 2~10 사이의 무작위 정수 생성
		int max = (int) (Math.random() * 9 + 2);

		for (int i = 0; i < max; i++) {
			char ch = 97;

			for (int j = 0; j <= i; j++) {
				System.out.print((char) (ch + j));
			}

			System.out.println();
		}
	}

}
