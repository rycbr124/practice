package sec02;

public class Address {
	//회원의 거주 도시와 우편번호를 저장합니다.
	private String city;
	private String zipcode;
	
	public Address() {
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
