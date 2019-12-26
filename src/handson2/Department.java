package handson2;

public class Department {
	
	private String city;
	private String name;

	public Department(String name,String city) {
		super();
		this.name=name;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Department [city=" + city + "]";
	}
	
	

}
