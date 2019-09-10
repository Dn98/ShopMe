<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body >



		<%@page import="java.sql.DriverManager"%>
		<%@page import="java.sql.ResultSet"%>
		<%@page import="java.sql.Statement"%>
		<%@page import="java.sql.Connection"%>

<br><h2 align="Center" >Retrieve All Information</h2><br>
<table border="1" align="Center">
<tr>
<th>ID</th>
<th>Card  Holder</th>
<th>Month</th>
<th>Year</th>
<th>Card No</th>
<th>CVC</th>



</tr>

<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/shopme","root", "");
    Statement st = conn.createStatement();
	String sql = "select id,cardholder,mm,yy,cardNo,cvc from payment";
	ResultSet rs = st.executeQuery(sql);
	while(rs.next()){	
%>
    
    <tr>
    
     <td><%=rs.getString("id") %></td>
    <td><%=rs.getString("cardholder") %></td>
    <td><%=rs.getString("mm") %></td>
    <td><%=rs.getString("yy") %></td>
     <td><%=rs.getString("cardNo") %></td>
    <td><%=rs.getString("cvc") %></td>
   
   
  
 
	</tr>
	<% 
	}
	conn.close();
    
    
    
    
}catch(Exception e)
{
	e.printStackTrace();
}

%>


</table>









</body>
</html>