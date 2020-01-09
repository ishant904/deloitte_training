package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "hr";
		String password ="hr";
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		try {
			DatabaseMetaData dbmeta=con.getMetaData();
			System.out.println(dbmeta.toString());
			System.out.println(dbmeta.getDatabaseMajorVersion());
			System.out.println(dbmeta.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql="select first_name,last_name,employee_id from employees where last_name='King'";
		try {
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();
			int type=rsmd.getColumnType(1);
			if(type == Types.INTEGER)
				System.out.println("int");
			else if(type==Types.VARCHAR)
				System.out.println("string");
			else if(type == Types.NUMERIC)
				System.out.println("numeric");
			System.out.println(colCount);
			while(rs.next()) {
				String id=rs.getString("employee_id");
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				System.out.println(id+":"+fname+":"+lname);
			}
			rs.close();
			st.close();
			con.close();
		}catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}

	}

}
