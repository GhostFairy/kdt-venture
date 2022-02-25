package dto;

// DATA TRANSFER OBJECT(VALUE OBJECT)
public class MemberDTO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;

	public MemberDTO(String id, String password, String name, String phone, String email, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return id + " 회원의 암호는 " + password + "이고, 이름은 " + name + ", 휴대폰 번호는 " + phone + ", 이메일 주소는 " + email + ", 주소는 " + address + "입니다.";
	}

}
