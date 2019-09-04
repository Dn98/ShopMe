package Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDATABASE {
	
	
	
	public boolean check(String adminName,String password)
	{
		String sql = "select AdminName,password from adminlogin where AdminName = ? and password = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/shopme","root", "");
		    PreparedStatement st = conn.prepareStatement(sql);
		    System.out.println("db connected!!");
		    st.setString(1, adminName);
		    st.setString(2, password);
		    ResultSet rs = st.executeQuery();
		    if(rs.next()){
		    	
		    	return true;
		    }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

}
