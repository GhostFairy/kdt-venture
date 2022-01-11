
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

		// 3개의 쓰레드를 시작하는 메소드 호출
		for (int i = 0; i < arr.length; i++) {
			arr[i].start();
		}
	}

}