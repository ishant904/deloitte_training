package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class EmpSalaryDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSalary("Neena"));

	}
	
	public static double getSalary(String name) {
		Connection con=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql="{call emp_sal(?,?)}";
		try {
			CallableStatement cst=con.prepareCall(sql);
			cst.setString(1,name);
			cst.registerOutParameter(2, Types.NUMERIC);
			cst.execute();
			return cst.getDouble(2);
		}catch(SQLException e) {e.printStackTrace();}
		return 0.0;
	}


}
