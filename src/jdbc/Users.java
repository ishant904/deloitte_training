package jdbc;

public class Users {
	private int id;
	private String name;
	private String userName;
	private String password;
	private String email;
	private Role role;
	public Users(int id, String name, String userName, String password, String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", email="
				+ email  + "]";
	}
	
	

}
