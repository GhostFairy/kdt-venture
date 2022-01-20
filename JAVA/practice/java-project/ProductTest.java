import java.text.DecimalFormat;

class Product {

	int prdNo; // 상품번호
	String prdName; // 상품명
	int prdPrice; // 가격
	int prdYear; // 연도
	String prdMaker; // 제조사

	// 값을 전달받아 필드를 초기화하는 생성자
	public Product(int prdNo, String prdName, int prdPrice, int prdYear, String prdMaker) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdYear = prdYear;
		this.prdMaker = prdMaker;
	}

	// 원하는 형태로 출력하기 위해 toString() 메소드를 오버라이딩
	@Override
	public String toString() {
		// 10진수 3자리로 표현, 빈 자리는 0으로 채움
		DecimalFormat df = new DecimalFormat("000");
		return df.format(prdNo) + "\t" + prdName + "\t" + prdPrice + "\t" + prdYear + "\t" + prdMaker;
	}

}

public class ProductTest {

	public static void main(String[] args) {
		Product notebook = new Product(1, "노트북", 1200000, 2021, "삼성");
		Product monitor = new Product(2, "모니터", 300000, 2021, "LG");
		Product mouse = new Product(3, "마우스", 30000, 2020, "로지텍");

		System.out.println("상품번호\t상품명\t가격\t연도\t제조사");
		System.out.println("----------------------------------------");
		System.out.println(notebook.toString());
		System.out.println(monitor.toString());
		System.out.println(mouse.toString());
	}

}
