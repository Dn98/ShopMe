package Servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.PreparableStatement;




@WebServlet("/LoingServlet")
public class LoingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email =  request.getParameter("email");
		String password = request.getParameter("password");
		
		loginDATABASE lg = new loginDATABASE();
		
		if(lg.check(email,password)) 
		{
		
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		

		
		
		
	}

}
