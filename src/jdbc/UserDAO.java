package jdbc;

import java.awt.DisplayMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO {

	private Connection con = null;
	private static List<Users> a;
	public UserDAO() {a=new ArrayList<>();} 
	
	public  void listUser() {
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = connector.getConnection();
		String sql ="select e.id,e.name,e.username,e.password,e.email,r.role_id,r.name from users e join role r on e.role_id=r.role_id";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				//System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6)+":"+rs.getString(7));
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String username=rs.getString(3);
				String password=rs.getString(4);
				String email=rs.getString(5);
				int roleId=rs.getInt(6);
				String roleName=rs.getString(7);
				Role r=new Role(roleId,roleName);
				Users u=new Users(id,name,username,password,email,r);
				addUsers(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addUsers(Users u) {
		a.add(u);
		displayUsers(a);
	}
	
	public void displayUsers(List a) {
		Iterator<Users> it=a.iterator();
		while(it.hasNext()) {
			Users u =it.next();
			System.out.println(u.getId()+" "+u.getName()+" "+u.getUserName()+" "+u.getPassword()+" "+u.getEmail()+" "+u.getRole().getRoleId()+" "+u.getRole().getName());
		}
	}
	
	public void displayRole(List a,String name) {
		Iterator<Users> it=a.iterator();
		while(it.hasNext()) {
			Users u =it.next();
			if(u.getName().equals(name))
				System.out.println(u.getRole().getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO s =new UserDAO();
		s.listUser();s.displayUsers(a);
		s.displayRole(a,"Ishant");

	}

}
