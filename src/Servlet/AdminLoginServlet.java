package Servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminName =  request.getParameter("adminName");
		String password = request.getParameter("password");
		
		AdminDATABASE lg  = new AdminDATABASE();
		if(lg.check(adminName,password)) 
		{
		
			response.sendRedirect("admin-page.jsp");
		}
		else
		{
			response.sendRedirect("Adminlogin.jsp");
		}
		
		
	}

}
