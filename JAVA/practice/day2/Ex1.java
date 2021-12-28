
public class Ex1 {

	public static void main(String[] args) {
		// 100~999 사이의 무작위 정수 생성
		int sample = (int) (Math.random() * 900 + 100);

		System.out.println(sample);
		System.out.println("백단위 출력: " + (sample / 100) * 100);
	}

}
