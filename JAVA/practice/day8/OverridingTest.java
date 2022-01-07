
class MySum {

	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	/* 조건1 */
	@Override
	public String toString() {
		return String.valueOf(first + second);
	}

	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MySum) {
			if (toString().equals(obj.toString())) {
				// 전달받은 class는 Object로 형변환되었으므로 obj.toString()은 Object의 toString()이지만
				// 상속받은 메소드를 Overriding한 경우 변경된 메소드를 호출하므로
				// obj가 MySum의 인스턴스일 때는 MySum의 toString()을 사용함
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

public class OverridingTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);

		System.out.println(ms1);
		System.out.println(ms2);

		if (ms1.equals(ms2)) {
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		}

		String s1 = new String("30");

		if (ms1.equals(s1)) {
			System.out.println("ms1과 s1의 합계는 동일합니다.");
		}
	}

}