package product;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDTO {

	int productCode;

	String productName;

	int price;

	String company;

	int balance;

	String regdate;

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(regdate.getTime()));
	}

}
