<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Patients</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<div class="image"></div>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<h3>Patient's List</h3>
<table id="profile">
	<tr>
		<th>Name</th>
		<th>Sex</th>
		<th>Contact Number</th>
		<th>Department</th>
		<th>E-Mail</th>
		<th>Password</th>
	</tr>
<%
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	java.sql.Statement st=con.createStatement();
	java.sql.ResultSet rs1;
	rs1=st.executeQuery("select pname, sex, contact, department, email,password from patient");
%>
<% while(rs1.next()){%>
<tr>
	<td><%out.print(rs1.getString(1)); %></td>
	<td class="alt"><%out.print(rs1.getString(2)); %></td>
	<td><%out.print(rs1.getString(3)); %></td>
	<td class="alt"><%out.print(rs1.getString(4)); %></td>
	<td><%out.print(rs1.getString(5)); %></td>
	<td class="alt"><%out.print(rs1.getString(6)); %>
</tr>
<%} %>
</table>
<div id="menu"><br>
<a href="adlist.jsp">Doctor's List</a><br>
<a href="dpdelete.jsp">Record Delete</a><br>
<a href="alogout.jsp">Logout</a>
</div>
<br><br><br><br><br><br><br><br>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>