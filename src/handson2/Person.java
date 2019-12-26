package handson2;

public class Person {
	
	private String name;
	private Address ad;
	
	public Person(String name) {
		this.name=name;
	}
	
	public Person(String name,Address ad) {
		this(name);
		this.ad=ad;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAd() {
		return ad;
	}

	public void setAd(Address ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", ad=" + ad + "]";
	}
	
	

}
