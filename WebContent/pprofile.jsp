<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Profile</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<div class="image"></div>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<h3>Profile</h3>
<table id="profile">
	<tr>
		<th>Name</th>
		<th>Sex</th>
		<th>Contact Number</th>
		<th>Department</th>
		<th>E-Mail</th>
	</tr>
<%
	Object str= request.getSession().getAttribute("username");
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	java.sql.Statement st=con.createStatement();
	java.sql.ResultSet rs1;
	rs1=st.executeQuery("select pname, sex, contact, department, email from patient where pname='"+str+"'");
%>
<% while(rs1.next()){%>
<tr>
	<td><%out.print(rs1.getString(1)); %></td>
	<td class="alt"><%out.print(rs1.getString(2)); %></td>
	<td><%out.print(rs1.getString(3)); %></td>
	<td class="alt"><%out.print(rs1.getString(4)); %></td>
	<td><%out.print(rs1.getString(5)); %></td>
</tr>
<%} %>
</table>
<br>
<div id="menu"><br>
<a href="pchoosedoctor.jsp">Submit Query</a><br>
<a href="plogout.jsp">Logout</a>
</div>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright � 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>