package ca.poltech.mybank.address;

public class Address {
	
	private String zipCode;
	private String address;
	private String unitNumber;
	private String city;
	private String province;
	private String country;
	
	
	public Address() {
		super();
	}
	
	
	public Address(String zipCode, String address, String unitNumber, String city, String province, String country) {
		this.zipCode = zipCode;
		this.address = address;
		this.unitNumber = unitNumber;
		this.city = city;
		this.province = province;
		this.country = country;
	}	
	
	
	//getters and setters
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	
	@Override
	public String toString() {
		return "Address [" + "zipCode=" + zipCode + ", address=" + address + ", unitNumber=" + unitNumber + ", city=" + city
				+ ", province=" + province + ", country=" + country + "]";
	}
	
}
