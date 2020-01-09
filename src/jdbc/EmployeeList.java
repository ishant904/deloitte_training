package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeList {

	Connection con = null;
	
	public EmployeeList() {}
	
	public void listEmployeeByDept(String deptName) {
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = connector.getConnection();
		String sql="select * from employees where department_id=(select department_id from departments where department_name='"+deptName+"')";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listEmployeeByDept(int dept) {
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = connector.getConnection();
		String sql="select * from employees where department_id=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,90);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmployeeList().listEmployeeByDept("Executive");
		new EmployeeList().listEmployeeByDept(90);
		

	}

}
