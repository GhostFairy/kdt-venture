
public class Ex2 {

	public static void main(String[] args) {
		int cntOfBooks = 97;
		int cntOfStu = 12;

		System.out.println("학생: " + cntOfStu + "명");
		System.out.println("책: " + cntOfBooks + "권");

		if (cntOfBooks > cntOfStu) {
			System.out.println("1명의 학생당 " + (cntOfBooks / cntOfStu) + "권씩 가질 수 있습니다.");
			System.out.println("남아있는 책은 " + (cntOfBooks % cntOfStu) + "권입니다.");
		} else if (cntOfBooks == cntOfStu) {
			System.out.println("1명의 학생당 1권씩 가질 수 있습니다.");
		} else {
			System.out.println("나눠줄 수 없습니다.");
		}
	}

}
