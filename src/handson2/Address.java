package handson2;

public class Address {
	
	private String houseNo;
	private String streetno;
	private String city;
	private String state;
	
	
	public Address(String houseNo, String streetno, String city, String state) {
		super();
		this.houseNo = houseNo;
		this.streetno = streetno;
		this.city = city;
		this.state = state;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetno() {
		return streetno;
	}
	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetno=" + streetno + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
