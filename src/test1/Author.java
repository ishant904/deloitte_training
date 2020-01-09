package test1;

public class Author {
	private String name;
	private String nationality;
	private Publisher pub;
	public Author(String name, String nationality,Publisher pub) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.pub=pub;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public Publisher getPub() {
		return pub;
	}
	public void setPub(Publisher pub) {
		this.pub = pub;
	}
	@Override
	public String toString() {
		return "Author [ name=" + name + ", nationality=" + nationality + "]";
	}
	
	

}
