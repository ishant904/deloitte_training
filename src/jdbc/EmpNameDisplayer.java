package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class EmpNameDisplayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayName(100);
	}
	
	public static void displayName(int id) {
		Connection con=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql="{call emp_disp(?,?,?)}";
		try {
			CallableStatement cst=con.prepareCall(sql);
			cst.setInt(1,id);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute();
			System.out.println(cst.getString(2));
		}catch(SQLException e) {e.printStackTrace();}
	}

}
