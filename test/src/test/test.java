package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String DBName = "todo";
		String todo = "テスト";
		int flag = checkDataBase(DBName);
		if(flag == 0) {createDataBase(DBName);}
		if(flag == 1) {writer.insertTable(DBName,todo);}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/" + DBName;
			con = DriverManager.getConnection(url,"root","admin");
			stmt = con.createStatement();
			String sql = "SELECT id, todo FROM todo.todolist";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("id : " + rs.getInt(1));
				System.out.println("todo :" + rs.getString(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	static void createDataBase(String DBName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/";
			con = DriverManager.getConnection(url,"root","admin");
			stmt = con.createStatement();
			String sql = "CREATE DATABASE " + DBName;
			stmt.executeUpdate(sql);
			con.close();
			stmt.close();

			url = "jdbc:mysql://localhost/" + DBName;
			con = DriverManager.getConnection(url,"root","admin");
			stmt = con.createStatement();
			sql = "CREATE TABLE todoList(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,todo varchar(255));";
			System.out.println(sql);
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

	static int checkDataBase(String DBName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection con = null;
		ResultSet rs = null;
		int flag = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/";
			con = DriverManager.getConnection(url,"root","admin");
			rs = con.getMetaData().getCatalogs();
			while(rs.next()) {
				if(DBName.equals(rs.getString(1)) ) flag = 1;
				System.out.println(rs.getString(1) + flag);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

}