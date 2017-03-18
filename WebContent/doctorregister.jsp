<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Registration Form</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<div class="image"></div>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<form action="dregister" method="post">
<div class="fieldSet">
<fieldset>
	<legend>REGISTRATION FORM</legend>
	<p><label class="field">Name: </label><input type="text" name="name" required="required"><br></p>
	<p><label class="field">Password: </label><input type="password" name="password" required="required"><br></p>
	<p><label class="field">Male:</label> <input type="radio" name="sex" value="male"></p>
	<p><label class="field">Female:</label> <input type="radio" name="sex" value="female" ></p>
 	<p><label class="field">Mobile: </label><input type="text" name="contact" required="required"> <br></p>
  	<p><label class="field">Speciality: </label><select name="speciality">
		<option value="Dermatology">Dermatology</option>
		<option value="Neurology">Neurology</option>
		<option value="Pathology">Pathology</option>
		<option value="Nephrology">Nephrology</option>
		<option value="Cardiology">Cardiology</option>
		<option value="Psychiatry">Psychiatry</option>
		</select><br>
	<p><label class="field">Email: </label><input type="text" name="email" required="required"><br></p>
	<p><input type="submit" value="Register"></p>
	</fieldset>
	</div>
</form>
<br><br><br><br><br><br>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>