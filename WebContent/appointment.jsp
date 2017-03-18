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
<h4>List of Doctors specializing in your selected Dept.<br></h4>
<table id="profile">
	<tr>
		<th>Name</th>
		<th>Sex</th>
		<th>Contact Number</th>
	</tr>
<%
	Object str= request.getSession().getAttribute("username");
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	java.sql.Statement st=con.createStatement();
	java.sql.ResultSet rs1;
	rs1=st.executeQuery("select doctor.dname, doctor.sex, doctor.contact from doctor, patient where doctor.speciality=patient.department and patient.pname='"+str+"'");
%>
<% while(rs1.next()){%>
<tr>
	<td><%out.print(rs1.getString(1)); %></td>
	<td class="alt"><%out.print(rs1.getString(2)); %></td>
	<td><%out.print(rs1.getString(3)); %></td>
</tr>
<%} %>
</table>
<br><br><br>
<form action="pchoosetime" method="post">
<div class="fieldSet">
<fieldset>
<legend>Choose your desired Doctor</legend>
<p><label class="field">Name of Doctor: </label><input type="text" name="dname" required="required"><br><br></p>
<p><p><label class="field">Select Time: </label><select name="time">
		<option value="11:00-12:00">11:00</option>
		<option value="17:00">17:00</option>
		<option value="20:00">20:00</option>
		</select><br><br></p>
<p><label class="submit"><input type="submit" value="Proceed"></label></p>
</fieldset>
</div>
</form>
<br>
<br>
<br>
<br>
<br><br>
<br>
<br>
<br>
<br>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>