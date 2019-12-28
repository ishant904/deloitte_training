package Test;

public class Department {
	
	private String city;
	private String name;

	public Department(String name,String city) {
		super();
		this.name=name;
		this.city = city;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Department [city=" + city + ", name=" + name + "]";
	}

	
	
	

}

