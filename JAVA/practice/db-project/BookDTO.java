
public class BookDTO {

	// 값을 숨기거나 가공하지 않고 그대로 주고 받을 것이기 때문에
	// getter/setter 대신 public으로 직접 접근 가능하게 선언
	public String bookNo;
	public String bookTitle;
	public String bookAuthor;
	public int bookYear;
	public int bookPrice;
	public String bookPublisher;

	public BookDTO(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice, String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}

}
