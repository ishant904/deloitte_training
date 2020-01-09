package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeDB {

	Connection con = null;
	List<Employee> a;
	int count=0;
	public EmployeeDB() {a=new ArrayList();}
	
	public void listEmployee(String date) {
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = connector.getConnection();
		String sql="select employee_id,first_name,last_name,department_id,salary,to_char(hire_date,'DD-MON-YYYY') from employees where hire_date < ?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, date);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				int deptId = rs.getInt(4);
				double sal = rs.getDouble(5);
				String jdate = rs.getString(6);
				SimpleDateFormat sdf=new SimpleDateFormat("DD-MMM-YYYY");
				Date joinDate=null;
				try {
					joinDate = sdf.parse(jdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Employee e = new Employee(id,fname+" "+lname,deptId,joinDate,sal);
				System.out.println(e);
				a.add(e);
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(a.size()); 
	}
	
	public static void main(String args[]) {
		new EmployeeDB().listEmployee("01-JAN-2010");
	}
	
}
