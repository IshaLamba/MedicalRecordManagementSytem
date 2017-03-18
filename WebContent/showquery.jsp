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
<h3>Patient's Query</h3>
<table id="profile">
	<tr>
	<th>Patient's Name</th>
		<th>Query</th>
	</tr>
<%
	String str1=request.getParameter("sname");
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	System.out.println("Connection established");
	java.sql.Statement st=con.createStatement();
	java.sql.ResultSet rs1;
	rs1=st.executeQuery("select pname,query from forum where pname='"+str1+"'");
%>
<% while(rs1.next()){%>
<tr>
	<td><%out.print(rs1.getString(1)); %></td>
	<td class="alt"><%out.println(rs1.getString(2));%></td>

</tr>
<%} %>
</table>
<br>
<form action="submitresponse" method="post">
<div class="fieldSet"><br>
<fieldset>
<p><label class="field">Name of Patient: </label><input type="text" name="sname" required="required"><br><br></p>
<p><label class="field">Response:</label><input type="text" name="respons" required="required"><br><br></p>
<p><label class="submit"><input type="submit" value="Submit Response"></label></p>
</fieldset>
</div>
</form>
<div id="menu"><br>
<a href="dloginmenu.jsp">Show menu</a>
</div>
<br><br><br><br><br><br><br><br><br>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>