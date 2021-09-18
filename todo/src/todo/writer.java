package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class writer {
	public static void insertTable(String DBName, String todo) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/" + DBName;
			con = DriverManager.getConnection(url,"root","admin");
			stmt = con.createStatement();
			String sql = "INSERT INTO todolist VALUES (0, '"+ todo +"',0);";
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}
