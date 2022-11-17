package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.Constants;

public class ConnectionDB {
	
	Constants c = new Constants();
	
	public Statement perform(String url, String user, String pass) 
			throws ClassNotFoundException, SQLException{
		
		Statement st;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection ct = DriverManager.getConnection(url,user,pass);
		st = ct.createStatement();
		return st;
	
	}
	
	public void getTableList(String tbl) throws ClassNotFoundException, SQLException {
		try {
		Statement st = perform(c.url(), c.us(), c.ps());
		ResultSet rs =  st.executeQuery("select * from "+tbl+" order by 1 desc;");
		
		while(rs.next()) {
			System.out.println(rs.getString(2));			
		}
		}catch(Exception e) {
			System.out.println("Exception on getTableList(x) > "+e);
		}
	}

	public void setTableData(String tbl, String info) throws ClassNotFoundException, SQLException {
		double _id = Math.random()*1000;
		String sql="";
		try {
		Statement st = perform(c.url(), c.us(), c.ps());
		sql = "insert into "+tbl+" values ("+_id+",'"+info+"');";
		st.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("Exception on setTableData(x,y) > "+e);
		}
	}
	
	
}
