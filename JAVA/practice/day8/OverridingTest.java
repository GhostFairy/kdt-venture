
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
	}

}