import java.text.DecimalFormat;

class Book {

	int bookNo; // 도서번호
	String bookTitle; // 도서명
	String bookAuthor; // 저자
	int bookYear; // 발행일
	int bookPrice; // 가격
	String bookPublisher; // 출판사

	// 값을 전달받아 필드를 초기화하는 생성자
	public Book(int bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookYear = bookYear;
		this.bookPublisher = bookPublisher;
	}

	// 원하는 형태로 출력하기 위해 toString() 메소드를 오버라이딩
	@Override
	public String toString() {
		return numberFormat(bookNo) + "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookYear + "\t" + bookPublisher;
	}

	// 맨 앞에 B를 붙이고 10진수 3자리로 표현, 빈 자리는 0으로 채움
	protected String numberFormat(int bookNo) {
		DecimalFormat df = new DecimalFormat("000");
		return "B" + df.format(bookNo);
	}

}

//Book 클래스를 상속받는 Magazine 클래스
class Magazine extends Book {

	int month; // 발행월

	// 값을 전달받아 필드를 초기화하는 생성자
	public Magazine(int bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher,	int month) {
		// 상속받은 슈퍼클래스의 필드는 슈퍼클래스의 생성자를 호출하여 초기화
		super(bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher);
		this.month = month;
	}

	// 원하는 형태로 출력하기 위해 toString() 메소드를 오버라이딩
	@Override
	public String toString() {
		// 상속받은 슈퍼클래스의 필드는 슈퍼클래스의 toString() 메소드를 호출하고 Magazine 클래스에만 있는 값을 덧붙임
		return super.toString() + "\t   " + month;
	}

	// 기본 동작은 같으나 맨 앞에 B대신 M을 붙이도록 오버라이딩
	@Override
	protected String numberFormat(int magazineNo) {
		DecimalFormat df = new DecimalFormat("000");
		return "M" + df.format(magazineNo);
	}

}

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book(1, "자바 프로그래밍", "홍길동", 25000, 2021, "멀티출판사");
		Book b2 = new Book(2, "자바스크립트", "이몽룡", 30000, 2020, "서울출판사");
		Book b3 = new Book(3, "HTML/CSS", "성춘향", 18000, 2021, "강남출판사");

		Magazine m1 = new Magazine(1, "자바 월드", "홍길동", 25000, 2021, "멀티출판사", 5);
		Magazine m2 = new Magazine(2, "웹 월드", "이몽룡", 30000, 2020, "서울출판사", 7);
		Magazine m3 = new Magazine(3, "게임 월드", "성춘향", 18000, 2021, "강남출판사", 9);

		System.out.println("도서번호\t도서명\t\t저자\t가격\t발행일\t출판사");
		System.out.println("------------------------------------------------------------");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
		System.out.println();
		System.out.println("잡지번호\t잡지명\t발행인\t가격\t발행연도\t출판사\t발행월");
		System.out.println("------------------------------------------------------------");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}

}
