
class MusicThread extends Thread {

	public MusicThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("음악 듣는 중입니다.");
			try {
				Thread.sleep((int) (Math.random() * 50));
			} catch (InterruptedException e) {
			}
		}
	}

}

class NewsThread extends Thread {

	public NewsThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("다운로드 중입니다.");
			try {
				Thread.sleep((int) (Math.random() * 50));
			} catch (InterruptedException e) {
			}
		}
	}

}

class DownloadThread extends Thread {

	public DownloadThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("뉴스 보는 중입니다.");
			try {
				Thread.sleep((int) (Math.random() * 50));
			} catch (InterruptedException e) {
			}
		}
	}

}

public class ThreadTest {

	public static void main(String[] args) {
		Thread arr[] = new Thread[3];
		arr[0] = new MusicThread("음악 쓰레드");
		arr[1] = new NewsThread("뉴스 쓰레드");
		arr[2] = new DownloadThread("다운로드 쓰레드");

		// interface Runnable { void run(); } -> 함수형 인터페이스 -> 람다식
		Thread t = new Thread(() -> {
			for (int i = 0; i < 7; i++) {
				Thread.currentThread().setName("카카오톡 쓰레드");
				System.out.println("카톡 보내는 중입니다.");
				try {
					Thread.sleep((int) (Math.random() * 50));
				} catch (InterruptedException e) {
				}
			}
		});

		// 3개의 쓰레드를 시작하는 메소드 호출
		arr[0].start();
		arr[1].start();
		arr[2].start();
		t.start();
	}

}