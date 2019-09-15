package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/REgistrationServlet")
public class REgistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		  Connection conn = null;
	        try {
	        	String sql = ("insert into register(name,password,email) values(?,?,?)");
				Class.forName("com.mysql.cj.jdbc.Driver");
			     conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/shopme","root", "");
			    PreparedStatement st = conn.prepareStatement(sql);
			    System.out.println("db connected!!");
			    st.setString(1, name);
			    st.setString(2, password);
			    st.setString(3, email);
			    int row = st.executeUpdate();
	            if (row > 0) {
	              System.out.println("File uploaded and saved into database");
	              response.sendRedirect("login.jsp");
	            }
			   
	        }catch (Exception e) {
				e.printStackTrace();
			}
	}

}
