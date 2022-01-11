
public class LambdaTest {

	public static void main(String[] args) {
		Thread arr[] = new Thread[3];

		// interface Runnable { void run(); } -> 함수형 인터페이스 -> 람다식
		arr[0] = new Thread(() -> {
			Thread.currentThread().setName("음악 쓰레드");
			for (int i = 0; i < 3; i++) {
				System.out.println("음악 듣는 중입니다.");
				try {
					Thread.sleep((int) (Math.random() * 50));
				} catch (InterruptedException e) {
				}
			}
		});
		arr[1] = new Thread(() -> {
			Thread.currentThread().setName("뉴스 쓰레드");
			for (int i = 0; i < 5; i++) {
				System.out.println("뉴스 보는 중입니다.");
				try {
					Thread.sleep((int) (Math.random() * 50));
				} catch (InterruptedException e) {
				}
			}
		});
		arr[2] = new Thread(() -> {
			Thread.currentThread().setName("다운로드 쓰레드");
			for (int i = 0; i < 10; i++) {
				System.out.println("다운로드 중입니다.");
				try {
					Thread.sleep((int) (Math.random() * 50));
				} catch (InterruptedException e) {
				}
			}
		});

		// 3개의 쓰레드를 시작하는 메소드 호출
		for (int i = 0; i < arr.length; i++) {
			arr[i].start();
		}
	}

}