<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose your Doctor</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<div class="image"></div>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<h3>List of Patients related to your speciality<br></h3>
<table id="profile">
	<tr>
		<th>Name</th>
		<th>Sex</th>
		<th>Contact</th>
		<th>Email</th>
		<th>
	</tr>
<%
	Object str= request.getSession().getAttribute("username");
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	java.sql.Statement st=con.createStatement();
	java.sql.ResultSet rs1;
	rs1=st.executeQuery("select patient.pname,patient.sex,patient.contact,patient.email from patient,doctor where patient.department=doctor.speciality and dname='"+str+"'");
%>
<% while(rs1.next()){%>
<tr>
	<td><%out.print(rs1.getString(1)); %></td>
	<td class="alt"><%out.print(rs1.getString(2)); %></td>
	<td><%out.print(rs1.getString(3)); %></td>
		<td class="alt"><%out.print(rs1.getString(4)); %></td>
</tr>
<%} %>
</table>
<br><br><br>
<form action="showquery.jsp" method="post">
<div class="fieldSet">
<fieldset>
<legend>Choose your Patient</legend>
<p><label class="field">Name of Patient: </label><input type="text" name="sname" required="required"><br><br></p>
<p><label class="submit"><input type="submit" value="Show Query"></label></p>
</fieldset>
</div>
</form>
<div id="menu"><br>
<a href="dloginmenu.jsp">Show Menu</a>
</div>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>