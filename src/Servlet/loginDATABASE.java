package Servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class loginDATABASE {

	public boolean check(String email,String password)
	{
		String sql = "select email,password from register where email = ? and password = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/shopme","root", "");
		    PreparedStatement st = conn.prepareStatement(sql);
		    System.out.println("db connected!!");
		    st.setString(1, email);
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
